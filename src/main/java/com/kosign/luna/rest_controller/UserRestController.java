package com.kosign.luna.rest_controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.PageReq;
import com.kosign.luna.model.user.UserDao;
import com.kosign.luna.model.user.UserRes;
import com.kosign.luna.model.user.UserResJoin;
import com.kosign.luna.repository.UserJoinCustRepo;
import com.kosign.luna.service.user.UserService;
import com.kosign.luna.util.ApiMapperUtile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(tags = "User", value = "user", description = "Controller for user control")
@RequestMapping("/user")
public class UserRestController {

    private UserService userService;
    private UserJoinCustRepo userJoinCustRepo;
    private ApiMapperUtile apiMapperUtile;

    @Autowired
    public void setApiMapperUtile(ApiMapperUtile apiMapperUtile) {
        this.apiMapperUtile = apiMapperUtile;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserJoinCustRepo(UserJoinCustRepo userJoinCustRepo) {
        this.userJoinCustRepo = userJoinCustRepo;
    }


    


    @PostMapping("/")
    public BaseApiResponse findAll(@RequestParam(defaultValue = "") String username, PageReq pageReq){
        BaseApiResponse result = new BaseApiResponse();
        Pageable pageable = PageRequest.of(pageReq.getPage(), pageReq.getOffset(), pageReq.getSortDirection(), pageReq.getSortBy());
            result.setCode("0000");
            result.setMessage("fetch data ok");
            result.setData(userService.findByUsernameContaining(username, pageable));

        return result;
    }

    @PostMapping("/all")
    public BaseApiResponse getAll(@RequestParam(defaultValue = "") String username, PageReq pageReq){
        BaseApiResponse result = new BaseApiResponse();
        Pageable pageable = PageRequest.of(pageReq.getPage(), pageReq.getOffset(), Sort.by("role").ascending().and(Sort.by("active").descending()));
            result.setCode("0000");
            result.setMessage("fetch data ok");
            result.setData(userJoinCustRepo.findByUsernameContainingIgnoreCase(username, pageable));

        return result;
    }

    @PostMapping("/enable/{id}")
    public BaseApiResponse enable(@PathVariable int id){
        BaseApiResponse result = new BaseApiResponse();
        boolean enable = userService.enable(id);
        if(!enable){
            result.setCode("0001");
            result.setMessage("Not found");
        }else {       
            UserDao userDao = userService.findByID(id);
            UserRes userRes = apiMapperUtile.mapper().map(userDao, UserRes.class);
            result.setCode("0000");
            result.setMessage("user enable");
            result.setData(userRes);
        }
        return result;
    }

    @GetMapping("/{id}")
    public BaseApiResponse findOne(@PathVariable int id){
        BaseApiResponse result = new BaseApiResponse();
        UserDao userDao = userService.findByID(id);
        if(userDao==null){
            result.setCode("0001");
            result.setMessage("Not found");
        }else {
            UserRes userRes = apiMapperUtile.mapper().map(userDao, UserRes.class);
            result.setCode("0000");
            result.setMessage("fetch data");
            result.setData(userRes);
        }
        return result;
    }



    @PostMapping("/delete/{id}")
    public BaseApiResponse delete(@PathVariable int id){
        BaseApiResponse result = new BaseApiResponse();
        boolean delete = userService.delete(id);
        if(!delete){
            result.setCode("0001");
            result.setMessage("Not found");
        }else {
            UserDao userDao = userService.findByID(id);
            UserRes userRes = apiMapperUtile.mapper().map(userDao, UserRes.class);
            result.setCode("0000");
            result.setMessage("fetch data");
            result.setData(userRes);
        }
        return result;
    }

}
