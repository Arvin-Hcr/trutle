package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.Permission;
import com.hcr.turtle.entiey.Tree;
import com.hcr.turtle.mapper.PermissionMapper;
import com.hcr.turtle.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 权限
 */
@SuppressWarnings("all")
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**获取权限
     * @param rnum
     * @return
     */
    @Override
    public List<Tree> getRolePer(Integer rnum) {
        List<Permission> list=permissionMapper.getAllPer();;
        List<Tree> treelist=new ArrayList<>();//记录树菜单数据
        int m=0;//标记treeList的长度不会随每次添加数据而改变,防止报错
        for (Permission p: list) {
            int pid=p.getPid(); //获取菜单的父id   1    0    系统管理   url
            Tree tree=new Tree(); //树数据tree类
            tree.setId(p.getId());
            tree.setLabel(p.getTitle());
            tree.setUrl(p.getUrl());
            tree.setIcon(p.getIcon());
            tree.setChildren(new ArrayList<Tree>());
            //System.out.println(tree);
            m=treelist.size();

            if(pid==0){
                treelist.add(tree);
                //System.out.println(treelist);
            }else{
                for (int i=0;i<m;i++){
                    //System.out.println("tr="+i);
                    Tree tr=treelist.get(i);
                    //System.out.println(tr);
                    if (tr!=null && pid==tr.getId()){
                        tr.getChildren().add(tree);
                        break;
                    }
                }
            }
        }
        //System.out.println(treelist);
        return treelist;
    }

    /**根据rid获取对应的pid
     * @param rid
     * @return
     */
    @Override
    public List getPidByRid(Integer rid) {
        Integer[] cids = permissionMapper.getPidByRid(rid);
        List list = new ArrayList();
        for(int i=0;i<cids.length;i++){
            if(cids[i]%100!=0){
                list.add(cids[i]);
            }
        }
        return list;
    }

    /**删除权限
     * @param rid
     * @return
     */
    @Override
    public int deletePer(Integer rid) {
        return permissionMapper.deletePer(rid);
    }

    /**增加权限
     * @param map
     * @return
     */
    @Override
    public int addPer(Map map) {
        int rid = (int) map.get("rid");
        int[] pid = (int[])map.get("pid");
        for (int i=0;i<pid.length;i++){
            permissionMapper.addPer(rid,pid[i]);
        }
        return pid.length;
    }


}
