package com.team.house_backapi.controller;

import com.team.house_backapi.service.DistrictService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/district/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getDistrictData")
    public BaseResult getDistrictData(){
        return new BaseResult(200,districtService.getDistrictAll());
    }
}
