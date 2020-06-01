package com.aaa.biz;

import com.aaa.entity.Dept;
import com.aaa.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:36
 * @Version 1.0
 */
public interface DeptBiz {
   int deleteByPrimaryKey(Integer deptId);

   int insert(Dept record);

   int insertSelective(Dept record);

   Dept selectByPrimaryKey(Integer deptId);

   int updateByPrimaryKeySelective(Dept record);

   int updateByPrimaryKey(Dept record);

   int delDeptByID( @Param("ids") List<String> ids);

   List<Dept> selectAllDept();
}
