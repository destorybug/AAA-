package com.aaa.biz.impl;

import com.aaa.biz.DeptBiz;
import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:49
 * @Version 1.0
 */
@Service
public class DeptBizImpl implements DeptBiz {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Integer deptId) {
        return 0;
    }

    @Override
    public int insert(Dept record) {
        return 0;
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return 0;
    }

    @Override
    public int delDeptByID(List<String> ids) {
        return deptMapper.delDeptByID(ids);
    }

    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }
}
