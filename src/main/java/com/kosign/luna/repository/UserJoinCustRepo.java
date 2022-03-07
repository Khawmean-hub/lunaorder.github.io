package com.kosign.luna.repository;

import com.kosign.luna.model.user.UserResJoin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserJoinCustRepo extends CrudRepository<UserResJoin, Integer>{
    Page<UserResJoin> findByUsernameContainingIgnoreCase(String username,Pageable pageable);
}
