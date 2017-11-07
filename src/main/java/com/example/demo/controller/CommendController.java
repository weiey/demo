package com.example.demo.controller;

import com.example.demo.po.Commend;
import com.example.demo.repository.CommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commend")
public class CommendController {

    @Autowired
    CommendRepository commendRepository;


    @RequestMapping("/save")
    public String saveCommend(Commend commend)
    {
        if(commend != null){
            commend.setTime(System.currentTimeMillis() + "");
        }
        Commend c = commendRepository.save(commend);
        System.out.println(c);
        return c.toString();
    }

    @RequestMapping("/getCommendUserName")
    public List getCommendUserName(Long id)
    {

        List c = commendRepository.findCommendUserId(id);

        System.out.println(c);
        return c;
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Commend>  getList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "15") Integer size){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);

        Page<Commend> page1 = commendRepository.findAll(pageable);
        List<Commend> list = page1.getContent();
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<Commend>  getList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "15") Integer size,Long userId){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);

        Page<Commend> page1 = commendRepository.findAll(pageable);
        List<Commend> list = page1.getContent();
        return list;
    }
}