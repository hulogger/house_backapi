package com.team.house_backapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house_backapi.domain.House;
import com.team.house_backapi.domain.HouseCondition;
import com.team.house_backapi.domain.Users;
import com.team.house_backapi.service.HouseService;
import com.team.house_backapi.util.BaseResult;
import com.team.house_backapi.util.FileUploadUtil;
import com.team.house_backapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/House/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("houseIssue")
    public BaseResult houseIssue(House house, HttpSession session,
            @RequestParam(value = "pfile",required = false) MultipartFile pfile){

        try {
            String path="D:\\images";//指定文件上传服务器
           String newPath= FileUploadUtil.upload(pfile,path);//用文件上传工具进行上传文件

            Users user=(Users) session.getAttribute("logininfo");
            house.setUserId(user.getId());//设置用户id
            house.setIsdel(new Integer(1));

            house.setId(System.currentTimeMillis()+"");//设置出租房的随机唯一编号(采用时间毫秒)
            System.out.println(newPath);
            house.setPath(newPath);//将 上传文件的路径保存在数据库中
            houseService.addHouse(house);//调用业务保存信息

            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(BaseResult.RESULT_FAIL,"发布失败",e.getMessage());
        }
    }


    @RequestMapping("getHouseByPage")
    public BaseResult getHouseByPage(HttpSession session, PageParmeter pageParmeter){
        Users logininfo = (Users) session.getAttribute("logininfo");
         PageInfo<House> housePageInfo = houseService.getHouseInfoByUserId(logininfo.getId(), pageParmeter);

        Map<String,Object> map=new HashMap<>();
        map.put("totle",housePageInfo.getPages());//保存总页数
        map.put("row",housePageInfo.getList());//保存数据
        return new BaseResult(200,map);
    }


    @RequestMapping("delHouse")
    public BaseResult delHouse(String id){
        int del=houseService.delHouse(id);
        if (del>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"删除成功");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"删除失败");
        }
    }

    @RequestMapping("searchHouseByPageInfo")
    public BaseResult searchHouseByPageInfo(HouseCondition houseCondition){
        PageInfo<House> pageInfo = houseService.getAllHouseData(houseCondition);

        Map<String,Object> map=new HashMap<>();
        map.put("curPage",pageInfo.getPageNum());
        map.put("totalPage",pageInfo.getPages());
        map.put("list",pageInfo.getList());
        return new BaseResult(200,map);

    }


}
