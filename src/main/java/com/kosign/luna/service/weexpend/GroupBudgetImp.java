package com.kosign.luna.service.weexpend;

import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.model.weexpend.GroupBudget;
import com.kosign.luna.model.weexpend.GroupBudgetRes;
import com.kosign.luna.model.weexpend.GroupPermission;
import com.kosign.luna.model.weexpend.UserInfo;
import com.kosign.luna.repository.CustomerRepository;
import com.kosign.luna.repository.GroupBudgetRepo;
import com.kosign.luna.repository.GroupPermissionRepo;
import com.kosign.luna.repository.GroupRecordRepo;
import com.kosign.luna.util.ApiMapperUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupBudgetImp implements GroupBudgetService{

    private GroupBudgetRepo groupBudgetRepo;
    private ApiMapperUtile apiMapperUtile;
    private GroupRecordRepo recordRepo;
    private GroupPermissionRepo permissionRepo;
    private CustomerRepository customerRepository;

    @Autowired
    public GroupBudgetImp(GroupBudgetRepo groupBudgetRepo, ApiMapperUtile apiMapperUtile, GroupRecordRepo recordRepo, GroupPermissionRepo permissionRepo, CustomerRepository customerRepository) {
        this.groupBudgetRepo = groupBudgetRepo;
        this.apiMapperUtile = apiMapperUtile;
        this.recordRepo = recordRepo;
        this.permissionRepo = permissionRepo;
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<GroupBudgetRes> getGroupBudget(Pageable pageable, int userId) {
        List<Integer> listGroupId = permissionRepo.findGroupIdByUserId(userId);
        Page<GroupBudget> list = groupBudgetRepo.findAllByActiveAndIdIn(true, pageable, listGroupId);
        Page<GroupBudgetRes> resp = list.map(e-> {
            List<Customer> customerList =customerRepository.findAllCustomersJpaQuery(e.getId());
            List<UserInfo> infoList = new ArrayList<>();
            customerList.forEach(val->{
                infoList.add(new UserInfo(val.getUserId(), val.getName(), val.getProfile()));
            });

            GroupBudgetRes res = apiMapperUtile.mapper().map(e, GroupBudgetRes.class);

            res.setMember(infoList);
            res.setTotalExpend(recordRepo.findTotalExpendById(e.getId()));
            res.setTotalIncome(recordRepo.findTotalIncomeById(e.getId()));
            return  res;
        });

        return resp;
    }

    @Override
    public GroupBudget save(GroupBudget groupBudget) {
        if(groupBudgetRepo.findById(groupBudget.getId())==null){
            return groupBudgetRepo.save(groupBudget);
        }else {
            return null;
        }
    }

    @Override
    public boolean update(GroupBudget groupBudget) {
        if(groupBudgetRepo.findById(groupBudget.getId())!=null){
            groupBudgetRepo.save(groupBudget);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        if(groupBudgetRepo.findById(id)!=null){
            groupBudgetRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public GroupBudgetRes findById(int id) {
        GroupBudget budget = groupBudgetRepo.findById(id);
        GroupBudgetRes budgetRes;
        if(budget!=null){
            budgetRes = apiMapperUtile.mapper().map(budget, GroupBudgetRes.class);
            List<Customer> customerList =customerRepository.findAllCustomersJpaQuery(id);
            List<UserInfo> infoList = new ArrayList<>();
            customerList.forEach(val->{
                infoList.add(new UserInfo(val.getUserId(), val.getName(), val.getProfile()));
            });
            budgetRes.setMember(infoList);
            budgetRes.setTotalExpend(recordRepo.findTotalExpendById(id));
            budgetRes.setTotalIncome(recordRepo.findTotalIncomeById(id));
            return budgetRes;
        }else
            return null;

    }

    @Override
    public boolean addMember(GroupPermission groupPermission) {
        GroupPermission group =  permissionRepo.findByGroupIdAndUsersId(groupPermission.getGroupId(), groupPermission.getUsersId());
        if(group!=null){
            return false;
        }else{
            permissionRepo.save(groupPermission);
            return true;
        }

    }

    @Override
    public boolean removeMember(int groupId, int userId) {
        GroupPermission group =  permissionRepo.findByGroupIdAndUsersId(groupId, userId);
        if(group!=null){
            permissionRepo.deleteById(group.getId());
            return true;
        }else{
            return false;
        }
    }
}
