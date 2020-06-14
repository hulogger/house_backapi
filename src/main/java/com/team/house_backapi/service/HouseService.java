package com.team.house_backapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house_backapi.domain.House;
import com.team.house_backapi.domain.HouseCondition;
import com.team.house_backapi.util.PageParmeter;

import java.util.List;

public interface HouseService {
     int addHouse(House house);

        PageInfo<House> getHouseInfoByUserId(Integer userId, PageParmeter pageParmeter);

        int delHouse(String id);



        PageInfo<House> getAllHouseData(HouseCondition houseCondition);
}
