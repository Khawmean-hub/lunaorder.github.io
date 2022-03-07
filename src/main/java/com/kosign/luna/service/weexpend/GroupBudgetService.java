package com.kosign.luna.service.weexpend;


import com.kosign.luna.model.weexpend.GroupBudget;
import com.kosign.luna.model.weexpend.GroupBudgetRes;
import com.kosign.luna.model.weexpend.GroupPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GroupBudgetService {
    Page<GroupBudgetRes> getGroupBudget(Pageable pageable, int userId);
    GroupBudget save(GroupBudget groupBudget);
    boolean update(GroupBudget groupBudget);
    boolean delete(int id);
    GroupBudgetRes findById(int id);

    boolean addMember(GroupPermission groupPermission);
    boolean removeMember(int groupId, int userId);


}
