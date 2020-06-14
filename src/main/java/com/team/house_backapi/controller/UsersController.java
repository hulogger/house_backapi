package com.team.house_backapi.controller;

import com.team.house_backapi.domain.Users;
import com.team.house_backapi.service.UsersService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Users/")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("regUser")
    public BaseResult regUser(Users users){
        int i = usersService.resUser(users);
        if (i>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"注册成功");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"系统正在维护");
        }
    }


    @RequestMapping("login")
    public BaseResult login(String username, String password, HttpSession session){
        Users users = usersService.login(username, password);
        if (users==null){
            return new BaseResult(BaseResult.RESULT_FAIL,"用户名密码不正确",users);
        }else {
            session.setAttribute("logininfo",users);
            session.setMaxInactiveInterval(6000); //10分钟
            return new BaseResult(BaseResult.RESULT_SUCCESS,"",users);
        }

    }
}
