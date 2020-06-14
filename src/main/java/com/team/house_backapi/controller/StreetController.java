package com.team.house_backapi.controller;

import com.team.house_backapi.service.StreetService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Street/")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetData")
    public BaseResult getStreetData(Integer disid){

        return new BaseResult(200,streetService.getStreetsByDisid(disid));
    }
}
