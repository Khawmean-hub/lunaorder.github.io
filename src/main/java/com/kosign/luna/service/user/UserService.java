package com.kosign.luna.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.kosign.luna.model.user.LoginReq;
import com.kosign.luna.model.user.UserDao;

public interface UserService extends UserDetailsService {

    UserDao findByUsername(String username);
    
    UserDao findByID(int id);

    Page<UserDao> findByUsernameContaining(String username, Pageable pageable);

    UserDao save(UserDao userDao);

    UserDao update(UserDao userDao);

    boolean delete(int id);

    boolean enable(int id);

    boolean changePassword(int id, String password);

    LoginReq register(LoginReq loginReq);
}
