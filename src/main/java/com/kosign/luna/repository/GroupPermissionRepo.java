package com.kosign.luna.repository;

import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.model.weexpend.GroupPermission;
import com.kosign.luna.model.weexpend.UserInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface GroupPermissionRepo extends CrudRepository<GroupPermission, Integer>{
    @Query(value = "SELECT group_id FROM group_permission WHERE users_id = :userId", nativeQuery = true)
    List<Integer> findGroupIdByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT users_id FROM group_permission WHERE group_id = :groupId", nativeQuery = true)
    List<Integer> findUserIdByGroupId(@Param("groupId") Integer groupId);


    GroupPermission findByGroupIdAndUsersId(int groupId, int userId);

    @Query(value = "SELECT id FROM group_permission WHERE group_id = :groupId", nativeQuery = true)
    List<Integer> findIdByGroupId(@Param("groupId") Integer groupId);

}
