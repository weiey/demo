package com.example.demo.repository;

import com.example.demo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
//    @Query("select count(bean.id) from User bean where bean.group = 3")
//    public long findByCk();
}
