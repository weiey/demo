package com.example.demo.repository;

import com.example.demo.po.Commend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommendRepository extends JpaRepository<Commend, Long> {
    @Query("select u.userName,u.nickName from Commend c, User u where c.userId =u.id and  c.id=?1")
    List findCommendUserId(Long id);
}
