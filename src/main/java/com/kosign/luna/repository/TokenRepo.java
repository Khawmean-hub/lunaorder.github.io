package com.kosign.luna.repository;

import com.kosign.luna.model.weexpend.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TokenRepo  extends CrudRepository<Token, Integer> {
    @Query(value = "SELECT * FROM tokens WHERE user_id IN (SELECT users_id FROM group_permission WHERE group_id = :groupId)", nativeQuery = true)
    List<Token> getTokenByUserId(@Param("groupId") Integer groupId);

    List<Token> findAll();
}
