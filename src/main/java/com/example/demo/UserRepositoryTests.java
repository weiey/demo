package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserRepositoryTests {

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
}