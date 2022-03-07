package com.kosign.luna.repository;

import com.kosign.luna.model.weexpend.GroupRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRecordRepo extends CrudRepository<GroupRecord, Integer> {
    @Query(value = "SELECT COALESCE(SUM(cash), 0) FROM group_record WHERE group_id = :id and type LIKE 'out'", nativeQuery = true)
    double findTotalExpendById(@Param("id") Integer id);

    @Query(value = "SELECT COALESCE(SUM(cash), 0) FROM group_record WHERE group_id = :id and type LIKE 'in'", nativeQuery = true)
    double findTotalIncomeById(@Param("id") Integer id);

    Page<GroupRecord> findAllByGroupId(Pageable pageable, int id);

    @Query(value = "SELECT * FROM group_record WHERE group_id = :id AND \"date\" BETWEEN TO_TIMESTAMP(:startDate,'YYYY-MM-DD') AND TO_TIMESTAMP(:endDate,'YYYY-MM-DD')", nativeQuery = true)
    List<GroupRecord> findAllByDate(@Param("id") int id,@Param("startDate") String startDate, @Param("endDate") String endDate);

    GroupRecord findById(int id);

    @Query(value = "SELECT profile FROM customers WHERE user_id = :id", nativeQuery = true)
    String findUserProfile(@Param("id") Integer id);

}
