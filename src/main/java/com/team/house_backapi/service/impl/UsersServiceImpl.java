package com.team.house_backapi.service.impl;

import com.team.house_backapi.dao.UsersMapper;
import com.team.house_backapi.domain.Users;
import com.team.house_backapi.domain.UsersExample;
import com.team.house_backapi.service.UsersService;
import com.team.house_backapi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public int resUser(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(username);

        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users!=null&&users.size()==1){
            return users.get(0);
        }else {
            return null;
        }

    }
}
