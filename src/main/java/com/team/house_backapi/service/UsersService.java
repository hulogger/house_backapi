package com.team.house_backapi.service;

import com.team.house_backapi.domain.Street;
import com.team.house_backapi.domain.Users;

public interface UsersService {
    int resUser(Users users);

    Users login(String username,String password);
}
