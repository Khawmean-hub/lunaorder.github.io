package com.kosign.luna.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.kosign.luna.model.user.UserDao;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {

    UserDao findByUsername(String username);
    
    UserDao findById(int id);

    Page<UserDao> findByUsernameContaining(String name,Pageable pageable);

}