package com.kosign.luna.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.model.user.LoginReq;
import com.kosign.luna.model.user.UserDao;
import com.kosign.luna.repository.CustomerRepository;
import com.kosign.luna.repository.UserRepository;
import com.kosign.luna.util.ApiMapperUtile;

@Service
public class UserServiceImp  implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    ApiMapperUtile apiMapperUtile;

    @Autowired
    public void setApiMapperUtile(ApiMapperUtile apiMapperUtile) {
        this.apiMapperUtile = apiMapperUtile;
    }
    
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDao findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userRepository.findByUsername(username);
        return user;
    }


    @Override
    public boolean delete(int id) {
        if(userRepository.findById(id)!=null){
            UserDao userDao = userRepository.findById(id);
            userDao.setActive(false);
            userRepository.save(userDao);
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public boolean changePassword(int id, String password) {
        if(userRepository.findById(id)!=null){
            UserDao userDao = userRepository.findById(id);
            userDao.setPassword(passwordEncoder.encode(password));
            userRepository.save(userDao);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UserDao findByID(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<UserDao> findByUsernameContaining(String username, Pageable pageable) {
        return userRepository.findByUsernameContaining(username, pageable);
    }

    @Override
    public UserDao save(UserDao userDao) {
        if(userRepository.findByUsername(userDao.getUsername())==null){
            userDao.setPassword(passwordEncoder.encode(userDao.getPassword()));
            userRepository.save(userDao);
            return userDao;
        }else{
            return null;
        }
    }

    @Override
    public UserDao update(UserDao userDao) {
        if(userRepository.findById(userDao.getId())!=null){
            userRepository.save(userDao);
            return userDao;
        }else{
            return null;
        }
    }

    @Override
    public LoginReq register(LoginReq loginReq) {
        if(userRepository.findByUsername(loginReq.getUsername())==null){
            UserDao userDao = new UserDao();
            userDao.setActive(false);
            userDao.setUsername(loginReq.getUsername());
            userDao.setRole("ROLE_USER");
            userDao.setPassword(passwordEncoder.encode(loginReq.getPassword()));

            int id = userRepository.save(userDao).getId();
            Customer customer = new Customer();
            customer.setUserId(id); 
            customer.setEnable(true);
            customerRepository.save(customer);
            return loginReq;
        }else{
            return null;
        }
    }

    @Override
    public boolean enable(int id) {
        if(userRepository.findById(id)!=null){
            UserDao userDao = userRepository.findById(id);
            userDao.setActive(true);
            userRepository.save(userDao);
            return true;
        }else{
            return false;
        }
    }

}
