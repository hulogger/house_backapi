package com.team.house_backapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house_backapi.dao.HouseMapper;
import com.team.house_backapi.domain.House;
import com.team.house_backapi.domain.HouseCondition;
import com.team.house_backapi.domain.HouseExample;
import com.team.house_backapi.service.HouseService;
import com.team.house_backapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseInfoByUserId(Integer userId, PageParmeter pageParmeter) {
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());//开启分页
        List<House> houseList = houseMapper.getHouseInfoByUserId(userId);
        return new PageInfo<House>(houseList);
    }

    @Override
    public int delHouse(String id) {
        return houseMapper.delHouse(id);
    }

    @Override
    public PageInfo<House> getAllHouseData(HouseCondition houseCondition) {
        if (houseCondition.getPrice()!=null&&!houseCondition.getPrice().equals("")){
            houseCondition.setStartPrice(Long.valueOf(Arrays.asList(houseCondition.getPrice().split("-")).get(0)));
            houseCondition.setEndPrice(Long.valueOf(Arrays.asList(houseCondition.getPrice().split("-")).get(1)));
        }
        if (houseCondition.getFloorage()!=null&&!houseCondition.getFloorage().equals("")){
            houseCondition.setStartFloorage(Integer.valueOf(Arrays.asList(houseCondition.getFloorage().split("-")).get(0)));
            houseCondition.setEndFloorage(Integer.valueOf(Arrays.asList(houseCondition.getFloorage().split("-")).get(1)));
        }
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());

        return new PageInfo<House>(houseMapper.getAllHouseData(houseCondition));
    }
}
