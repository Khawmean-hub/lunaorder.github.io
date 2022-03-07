package com.kosign.luna.rest_controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import com.kosign.luna.configuration.jwconfiguration.JwtTokenUtil;
import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.model.jwt.JwtResponse;
import com.kosign.luna.model.user.LoginReq;
import com.kosign.luna.model.user.UserDao;
import com.kosign.luna.model.user.UserRes;
import com.kosign.luna.repository.CustomerRepository;
import com.kosign.luna.service.user.UserService;
import com.kosign.luna.util.ApiMapperUtile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "Login", value = "login", description = "Controller for user and admin login")
@RestController
public class LoginRestController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private ApiMapperUtile apiMapperUtile;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public Map<String, Object> createAuthenticationToken(@Validated @RequestBody LoginReq user) throws Exception {

        Map<String, Object> result = new HashMap<>();
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            if (userDetails != null) {
                final String token = jwtTokenUtil.generateToken(userDetails);
                    UserDao user1 = userService.findByUsername(user.getUsername());
                    UserRes userRes = apiMapperUtile.mapper().map(user1, UserRes.class);
                    Customer customer = customerRepository.findByUserId(userRes.getId());
                if(userRes.getActive()){
                    
                    JwtResponse jwt  = new JwtResponse(token);
                    result.put("code", "0000");
                    result.put("message", "login successfully!");
                    result.put("data", userRes);
                    result.put("profile", customer);
                    result.put("token", jwt.getJwtToken());
                    
                   
                }else {
                    result.put("code", "0003");
                    result.put("message", "Your account is not yet approve!");
                }
              
            }
        } catch (Exception e) {
            result.put("code", "0001");
            result.put("message", "Incorrect username or password");
            // e.printStackTrace();
            // throw new Exception("Incorrect email or password", e);
        }

        return result;
    }


    @PostMapping("/register")
    public BaseApiResponse register(@Validated @RequestBody LoginReq user){
        BaseApiResponse result = new BaseApiResponse();
        if(userService.register(user)!=null){
            result.setCode("0000");
            result.setMessage("Register successfully");
            result.setData(user);
        }else {
            result.setCode("0002");
            result.setMessage(user.getUsername() + " is already exit");
            result.setData(user);
        }
        return result;
    }

    @GetMapping("/")
    public String welcom(){
        // System.out.println(">>>>>>>>>>> "+userService.findByUsername("admin").toString());
        return "Hello yun yath";
    }

    // @GetMapping("/check")
    // public BaseApiResponse<String> check(){
    //     BaseApiResponse<String> apiResponse = new BaseApiResponse<>();
    //     apiResponse.setCode("0000");
    //     apiResponse.setMessage("token is work");
    //     return apiResponse;
    // }
}
