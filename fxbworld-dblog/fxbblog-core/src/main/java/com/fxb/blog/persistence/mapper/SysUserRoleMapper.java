package com.fxb.blog.persistence.mapper;

import com.fxb.blog.persistence.beans.SysUserRole;
import com.fxb.blog.plugin.BaseMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    List<Integer> findUserIdByRoleId(Integer roleId);
}
