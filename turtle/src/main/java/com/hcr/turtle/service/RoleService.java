package com.hcr.turtle.service;

import com.hcr.turtle.entiey.Role;
import com.hcr.turtle.util.Page;

/**
 * 角色
 */
public interface RoleService {

    /**获取角色
     * @param role
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page getAllRole(Role role, int currentPage, int pageSize);


    /**根据编号获取角色
     * @param rnum
     * @return
     */
    public Role getRoleByNum(Integer rnum);


    /**添加角色
     * @param role
     * @return
     */
    public int addRole(Role role);

    /**修改角色信息
     * @param role
     * @return
     */
    public int updateRole(Role role);


    /**删除角色
     * @param id
     * @return
     */
    public int deleteRole(Integer id);

    /**获取所有角色编号
     * @param
     * @return
     */
    public int[] getRoleNum();

}
