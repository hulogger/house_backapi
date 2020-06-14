package com.team.house_backapi.dao;

import com.team.house_backapi.domain.House;
import com.team.house_backapi.domain.HouseCondition;
import com.team.house_backapi.domain.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询某用户下的出租房信息
    List<House> getHouseInfoByUserId(Integer userId);

    //逻辑删除房屋
    int delHouse(String id);

    List<House> getAllHouseData(HouseCondition houseCondition);
}