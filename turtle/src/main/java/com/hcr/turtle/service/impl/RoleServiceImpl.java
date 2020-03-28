package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.Role;
import com.hcr.turtle.mapper.RoleMapper;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.service.RoleService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 角色
 */
@Service
@SuppressWarnings("all")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**获取所有角色
     * @param role
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page getAllRole(Role role, int currentPage, int pageSize) {
        RowBounds rowBounds=new RowBounds((currentPage-1) * pageSize,pageSize);
        List<Role> role1 = roleMapper.getAllRole(role,rowBounds);
        int count = roleMapper.roleCount(role);
        return new Page(role1,count);
    }

    /**根据角色编号获取角色
     * @param rnum
     * @return
     */
    @Override
    public Role getRoleByNum(Integer rnum) {
        Role roleByNum = roleMapper.getRoleByNum(rnum);
        if (roleByNum!=null){
            return roleByNum;
        }
        return null;
    }

    /**添加角色
     * @param role
     * @return
     */
    public int addRole(Role role){
        return roleMapper.addRole(role);
    }

    /**修改角色信息
     * @param role
     * @return
     */
    public int updateRole(Role role){
        return  roleMapper.updateRole(role);
    }

    /**删除角色
     * @param id
     * @return
     */
    public int deleteRole(Integer id){
        return  roleMapper.deleteRole(id);
    }

    /**获取所有角色
     * @param
     * @return
     */
    @Override
    public int[] getRoleNum() {
        return roleMapper.getRoleNum();
    }


}
