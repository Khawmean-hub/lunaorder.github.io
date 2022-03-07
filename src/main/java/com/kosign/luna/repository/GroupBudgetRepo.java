package com.kosign.luna.repository;

import com.kosign.luna.model.weexpend.GroupBudget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupBudgetRepo extends CrudRepository<GroupBudget, Integer> {
    Page<GroupBudget> findAllByActiveAndIdIn(boolean isActive, Pageable pageable, List<Integer> id);
    GroupBudget findById(int id);
}
