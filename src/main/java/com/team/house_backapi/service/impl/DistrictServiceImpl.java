package com.team.house_backapi.service.impl;

import com.team.house_backapi.dao.DistrictMapper;
import com.team.house_backapi.domain.District;
import com.team.house_backapi.domain.DistrictExample;
import com.team.house_backapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Override
    public List<District> getDistrictAll() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
