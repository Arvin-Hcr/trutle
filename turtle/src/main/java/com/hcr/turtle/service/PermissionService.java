package com.hcr.turtle.service;

import com.hcr.turtle.entiey.Tree;

import java.util.List;
import java.util.Map;

/**
 * 权限
 */
public interface PermissionService {

    /**根据角色编号获取对应的权限
     * @param
     * @return
     */
    public List<Tree> getRolePer(Integer rnum);


    /**根据rid获取对应的pid
     * @param id
     * @return
     */
    public List getPidByRid(Integer id);

    /**增加权限
     * @param map
     * @return
     */
    public int addPer(Map map);


    /**根据rid删除对应权限
     * @param rid
     * @return
     */
    public int deletePer(Integer rid);


}
