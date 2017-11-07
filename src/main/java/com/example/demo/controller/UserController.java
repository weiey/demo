package com.example.demo.controller;

import com.example.demo.po.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository accountRepository;

    @RequestMapping("/info")
    public String getAdminInfo(String currentAccount)
    {
        User account = accountRepository.findByUserName(currentAccount);
        System.out.println(account);
        return account.toString();
    }
    @RequestMapping("/save")
    public String saveUser(User user)
    {
        User account = accountRepository.save(user);
        System.out.println(account);
        return account.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public Page<User> getList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "15") Integer size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return accountRepository.findAll(pageable) ;
    }
}