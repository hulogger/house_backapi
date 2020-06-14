package com.team.house_backapi.dao;

import com.team.house_backapi.domain.Street;
import com.team.house_backapi.domain.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    List<Street> selectStreetsByDisid(Integer disid);
}