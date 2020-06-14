package com.team.house_backapi.controller;

import com.team.house_backapi.service.TypeService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type/")
public class TypeController {
    @Autowired(required = false)
    private TypeService typeService;
    @RequestMapping("getTypeData")
    public BaseResult getTypeDats(){
        return new BaseResult(200,typeService.getAllType());
    }

}
