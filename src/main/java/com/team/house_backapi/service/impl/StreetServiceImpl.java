package com.team.house_backapi.service.impl;

import com.team.house_backapi.dao.StreetMapper;
import com.team.house_backapi.domain.Street;
import com.team.house_backapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl  implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;
    @Override
    public List<Street> getStreetsByDisid(Integer disid) {
        return streetMapper.selectStreetsByDisid(disid);
    }
}
