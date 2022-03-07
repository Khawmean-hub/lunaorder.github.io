package com.kosign.luna.service.weexpend;

import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.model.message.PushNotificationRequest;
import com.kosign.luna.model.weexpend.GroupBudget;
import com.kosign.luna.model.weexpend.GroupRecord;
import com.kosign.luna.model.weexpend.GroupRecordRes;
import com.kosign.luna.model.weexpend.Token;
import com.kosign.luna.repository.CustomerRepository;
import com.kosign.luna.repository.GroupBudgetRepo;
import com.kosign.luna.repository.GroupRecordRepo;
import com.kosign.luna.repository.TokenRepo;
import com.kosign.luna.service.messave.PushNotificationService;
import com.kosign.luna.util.ApiMapperUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class GroupRecordImp implements GroupRecordService{

    private GroupRecordRepo repo;
    private GroupBudgetRepo budgetRepo;
    private CustomerRepository customerRepository;
    private ApiMapperUtile map;
    private PushNotificationService notificationService;
    private TokenRepo tokenRepo;

    @Autowired
    public GroupRecordImp(GroupRecordRepo repo, GroupBudgetRepo budgetRepo, CustomerRepository customerRepository, ApiMapperUtile map, PushNotificationService notificationService, TokenRepo tokenRepo) {
        this.repo = repo;
        this.budgetRepo = budgetRepo;
        this.customerRepository = customerRepository;
        this.map = map;
        this.notificationService = notificationService;
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Page<GroupRecordRes> getAll(Pageable pageable, @RequestParam int id) {

        Page<GroupRecordRes> resp = repo.findAllByGroupId(pageable, id).map(e->{
            GroupRecordRes gres = map.mapper().map(e, GroupRecordRes.class);
            gres.setUserProfile(repo.findUserProfile(e.getByUserId()));
            return gres;
        });

        return resp;
    }

    @Override
    public List<GroupRecordRes> getAllByDate(@RequestParam int id, String startDate, String endDate) {

        List<GroupRecordRes> resp = new ArrayList<>();
        repo.findAllByDate(id, startDate, endDate).forEach(e->{
            GroupRecordRes gres = map.mapper().map(e, GroupRecordRes.class);
            gres.setUserProfile(repo.findUserProfile(e.getByUserId()));
            resp.add(gres);
        });

        return resp;
    }

    @Override
    public boolean save(GroupRecord groupRecord) {
        if(repo.findById(groupRecord.getId())!=null){
            return false;
        }else{
            GroupBudget budget = budgetRepo.findById(groupRecord.getGroupId());
            Customer customer = customerRepository.findByUserId(groupRecord.getByUserId());
            NumberFormat nf = NumberFormat.getInstance(new Locale("km"));
            List<Token> tokens = tokenRepo.getTokenByUserId(groupRecord.getGroupId());
            if(budget!=null && tokens.size() > 0){
                String title = budget.getName();
                String msg;
                if(groupRecord.getType()=="in"){
                    title += " Income";
                    msg = customer.getName() + " has cash in " + nf.format(groupRecord.getCash());
                }else {
                    title += " Expend";
                    msg = customer.getName() + " has expend " + nf.format(groupRecord.getCash())+ " for " + groupRecord.getTitle();
                }

                String finalTitle = title;
                tokens.forEach((e)->{
                    if(e.getUserId()!= groupRecord.getByUserId()){
                        PushNotificationRequest request = new PushNotificationRequest(finalTitle, msg, null, e.getDeviceToken());
                        notificationService.sendPushNotificationToToken(request);
                    }

                });

            }


            repo.save(groupRecord);
            return true;
        }

    }

    @Override
    public boolean update(GroupRecord groupRecord) {

        if(repo.findById(groupRecord.getId())!=null){
            repo.save(groupRecord);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        if(repo.findById(id)!=null){
            repo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
