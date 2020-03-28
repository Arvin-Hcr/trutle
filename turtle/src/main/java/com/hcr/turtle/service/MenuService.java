package com.hcr.turtle.service;

import com.hcr.turtle.entiey.Permission;
import com.hcr.turtle.entiey.Tree;
import com.hcr.turtle.util.Page;

import java.util.List;

/**
 * 菜单操作
 */
public interface MenuService {

    /**一二级菜单
     * @param
     * @return
     */
    public List<Tree> getMenuTree();


    /**获取父菜单
     * @param permission
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page getFatherMenu(Permission permission, int currentPage, int pageSize);

    /**添加父菜单
     * @param permission
     * @return
     */
    public int addFatherMenu(Permission permission);

    /**修改父菜单信息
     * @param permission
     * @return
     */
    public int updateFatherMenu(Permission permission);


    /**删除父菜单与其下方的子菜单
     * @param id
     * @return
     */
    public int deleteFatherMenu(Integer id);

    /**获取子菜单
     * @param permission
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page getSonMenu(Permission permission, int currentPage, int pageSize);

    /**添加子菜单
     * @param permission
     * @return
     */
    public int addSonMenu(Permission permission);

    /**修改子菜单信息
     * @param permission
     * @return
     */
    public int updateSonMenu(Permission permission);


    /**删除子菜单
     * @param id
     * @return
     */
    public int deleteSonMenu(Integer id);


}
