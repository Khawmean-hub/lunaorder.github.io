package com.kosign.luna.rest_controller;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.PageReq;
import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.model.message.PushNotificationRequest;
import com.kosign.luna.model.weexpend.*;
import com.kosign.luna.repository.*;
import com.kosign.luna.service.messave.PushNotificationService;
import com.kosign.luna.service.weexpend.GroupBudgetService;
import com.kosign.luna.service.weexpend.GroupRecordService;
import io.swagger.annotations.Api;
import net.bytebuddy.utility.JavaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/weexpend")
@Api(tags = "WeExpend", value = "data of weexpend")
public class WeExpend {

    private GroupBudgetService service;
    private GroupRecordService recordService;
    private GroupRecordRepo recordRepo;
    private TokenRepo tokenRepo;
    private CustomerRepository customerRepository;
    private PushNotificationService notificationService;
    private GroupPermissionRepo permissionRepo;

    @Autowired
    public WeExpend(GroupBudgetService service, GroupRecordService recordService, GroupRecordRepo recordRepo, TokenRepo tokenRepo, CustomerRepository customerRepository, PushNotificationService notificationService, GroupPermissionRepo permissionRepo) {
        this.service = service;
        this.recordService = recordService;
        this.recordRepo = recordRepo;
        this.tokenRepo = tokenRepo;
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
        this.permissionRepo = permissionRepo;
    }

    @PostMapping("/group-budget/get")
    public BaseApiResponse getAllBudget(PageReq pageReq, int userId){
        Pageable pageable = PageRequest.of(pageReq.getPage(), pageReq.getOffset(), pageReq.getSortDirection(), pageReq.getSortBy());
        BaseApiResponse response = new BaseApiResponse();
        Page<GroupBudgetRes> data = service.getGroupBudget(pageable, userId);
        response.setCode("0000");
        response.setMessage("Success");
        response.setData(data);

        return response;
    }

    @PostMapping("/group-budget/save")
    public BaseApiResponse saveBudget(@RequestBody GroupBudget budget){

        BaseApiResponse response = new BaseApiResponse();
        GroupBudget groupBudget = service.save(budget);
        if(groupBudget!=null){
            response.setCode("0000");
            response.setMessage("Save Group Budget successfully");
            response.setData(groupBudget.getId());
        }else {
            response.setCode("0000");
            response.setMessage("Record already exist.");
        }

        return response;
    }

    @PutMapping("/group-budget")
    public BaseApiResponse updateBudget(@RequestBody GroupBudget budget){
        BaseApiResponse response = new BaseApiResponse();
        boolean isUpdate = service.update(budget);
        if(isUpdate){
            response.setCode("0000");
            response.setMessage("Update successfully");
        }else{
            response.setCode("0009");
            response.setMessage("Record does not exist.");
        }

        return  response;
    }

    @DeleteMapping("/group-budget/{id}")
    public BaseApiResponse deleteBudget(@PathVariable int id){
        BaseApiResponse response = new BaseApiResponse();
        boolean isDelete = service.delete(id);

        if(isDelete){
            List<Integer> listId = permissionRepo.findIdByGroupId(id);
            listId.forEach((e)->{
                permissionRepo.deleteById(e);
            });
            response.setCode("0000");
            response.setMessage("Delete successfully");
        }else{
            response.setCode("0009");
            response.setMessage("Record does not exist.");
        }
        return response;
    }

//    Group Record

    @PostMapping("/group-record")
    public BaseApiResponse getAllRecord(PageReq pageReq, int groupId){
        Pageable pageable = PageRequest.of(pageReq.getPage(), pageReq.getOffset(), pageReq.getSortDirection(), pageReq.getSortBy());
        Page<GroupRecordRes> data = recordService.getAll(pageable,groupId);

        BaseApiResponse response = new BaseApiResponse();
        response.setCode("0000");
        response.setMessage("Fitch data successfully");
        response.setData(data);

        return response;
    }

    @PostMapping("/group-record/date")
    public BaseApiResponse getAllRecordByDate(int groupId, String startDate, String endDate){

        List<GroupRecordRes> data = recordService.getAllByDate(groupId, startDate, endDate);

        BaseApiResponse response = new BaseApiResponse();
        response.setCode("0000");
        response.setMessage("Fitch data successfully");
        response.setData(data);

        return response;
    }

    @PostMapping("/group-record/save")
    public BaseApiResponse saveRecord(@RequestBody GroupRecord record){
        BaseApiResponse response = new BaseApiResponse();
        boolean isSave = recordService.save(record);
        if(isSave){
            response.setCode("0000");
            response.setMessage("Save successfully");
        }else {
            response.setCode("0009");
            response.setMessage("Record already Exist");
        }
        return response;
    }

    @PutMapping("/group-record")
    public BaseApiResponse updateRecord(@RequestBody GroupRecord record){
        BaseApiResponse response = new BaseApiResponse();
        boolean isUpdate = recordService.update(record);
        if(isUpdate){
            response.setCode("0000");
            response.setMessage("Save successfully");
        }else {
            response.setCode("0009");
            response.setMessage("Record already Exist");
        }
        return response;
    }

    @DeleteMapping("/group-record/{id}")
    public BaseApiResponse delete(@PathVariable int id){
        BaseApiResponse response = new BaseApiResponse();
        boolean isDelete = recordService.delete(id);
        if(isDelete){
            response.setCode("0000");
            response.setMessage("Delete successfully");
        }else {
            response.setCode("0009");
            response.setMessage("Record does not exist");
        }
        return response;
    }

    @GetMapping("/group-record/balance/{id}")
    public BaseApiResponse balance(@PathVariable int id){
        BaseApiResponse response = new BaseApiResponse();

        response.setCode("0000");
        response.setMessage("Get balance successfully");
        response.setData(recordRepo.findTotalIncomeById(id) - recordRepo.findTotalExpendById(id));

        return response;
    }

    @PostMapping("/group/add-member")
    public BaseApiResponse addMember(@RequestBody GroupPermission groupPermission){
        BaseApiResponse response = new BaseApiResponse();
        boolean isSave = service.addMember(groupPermission);
        if(isSave){

            response.setCode("0000");
            response.setMessage("Save successfully");
        }else {
            response.setCode("0009");
            response.setMessage("Record already Exist");
        }
        return response;
    }

    @DeleteMapping("/group/remove-member")
    public BaseApiResponse delete(@RequestParam int groupId, @RequestParam int userId){
        BaseApiResponse response = new BaseApiResponse();
        boolean isDelete = service.removeMember(groupId, userId);
        if(isDelete){
            response.setCode("0000");
            response.setMessage("Remove successfully");
        }else {
            response.setCode("0009");
            response.setMessage("Record does not exist");
        }
        return response;
    }

    @PostMapping("/token")
    public BaseApiResponse saveToken(@RequestBody Token token){
       boolean isDouble = false;
        List<Token> tokenList = tokenRepo.findAll();
        BaseApiResponse response = new BaseApiResponse();
        for (Token item: tokenList) {
            if(item.getDeviceToken().contains(token.getDeviceToken())){
                if(item.getUserId() == token.getUserId()){
                    isDouble = true;
                    break;
                }else {
                    token.setId(item.getId());
                }

            }
        }

        if(!isDouble){
            tokenRepo.save(token);
            response.setCode("0000");
            response.setMessage("Save successfully");
        }else {
            response.setCode("0009");
            response.setMessage("Record already Exist");
        }


        return response;
    }

    @GetMapping("/users")
    public BaseApiResponse getAllUser(){
        BaseApiResponse response = new BaseApiResponse();
        List list = new ArrayList();
        customerRepository.findAll().forEach((e)->{
            Map<String, String> res = new HashMap<>();
            res.put("id", e.getUserId()+"");
            res.put("email", e.getEmail());
            res.put("profile", e.getProfile());
            list.add(res);
        });


        response.setCode("0000");
        response.setMessage("Get all users successfully");
        response.setData(list);

        return response;
    }

    @PostMapping("/group-permission")
    public BaseApiResponse saveGroupPermission(@RequestBody List<GroupPermission> group){
        BaseApiResponse response = new BaseApiResponse();
        List<GroupPermission> addList = group;

        permissionRepo.findAll().forEach((e)->{
            for (GroupPermission item: group  ) {
                if(e.getGroupId() == item.getGroupId() && e.getUsersId() == item.getUsersId()){
                    try {
                        addList.remove(item);
                    }catch (Exception ex){}
                }
            }
        });

        for (GroupPermission item: addList) {
            permissionRepo.save(item);
        }

        response.setCode("0000");
        response.setMessage("Save successfully");

        return response;
    }

}
