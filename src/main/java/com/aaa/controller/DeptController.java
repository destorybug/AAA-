package com.aaa.controller;

import com.aaa.biz.DeptBiz;
import com.aaa.entity.Dept;
import com.aaa.entity.LayUiTable;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptBiz deptBizImpl;
    @RequestMapping("/toShowDept")
    public String  toShowDept(){
        return "dept/showDept";
    }

    @RequestMapping("/showDept")
    @ResponseBody
    public LayUiTable showDept(Model model) {
        //开始查询
        List<Dept> deptList = deptBizImpl.selectAllDept();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(deptList);
        List<Dept> depts = deptBizImpl.selectAllDept();
        model.addAttribute("depts",depts);
        return layUiTable;
    }
    @RequestMapping("/saveDept")
    @ResponseBody
    public Object saveDept(Dept dept) {
        dept.setCreateBy("admin");
        dept.setCreateTime(new Date());
        int i = deptBizImpl.insertSelective(dept);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.saveSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.saveFailMsg);
        }
        return map;
    }

    @RequestMapping("/editDept")
    @ResponseBody
    public Object editDept(Dept dept) {
        dept.setCreateBy("admin");
        dept.setCreateTime(new Date());
        int i = deptBizImpl.updateByPrimaryKeySelective(dept);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.editSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping("/delDept")
    @ResponseBody
    public Object delDept(@RequestParam(value = "ids") String ids) {
        //将json字符串转换成list对象
        List<String> list = (List<String>) JSON.parse(ids);
        int i = deptBizImpl.delDeptByID(list);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.delSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.delFailMsg);
        }
        return map;
    }
}
