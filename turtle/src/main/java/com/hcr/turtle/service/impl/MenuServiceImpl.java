package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.Permission;
import com.hcr.turtle.entiey.Tree;
import com.hcr.turtle.util.EmpUtil;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.mapper.MenuMapper;
import com.hcr.turtle.service.MenuService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单操作
 */
@SuppressWarnings("all")
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    /**
     * 从session中获取用户的id
     * 根据用户id获取一二级菜单
     * @return
     */
    @Override
    public List<Tree> getMenuTree() {
        List<Permission> list=menuMapper.getMenuTree(EmpUtil.getEmpFromSession().getId());
        //System.out.println("数据"+list);
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

    /**获取父菜单
     * @param permission
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page getFatherMenu(Permission permission, int currentPage, int pageSize) {
        RowBounds rowBounds=new RowBounds((currentPage-1) * pageSize,pageSize);
        List<Permission> fatherMenu = menuMapper.getFatherMenu(permission, rowBounds);
        int fatherMenuCount = menuMapper.FatherMenuCount(permission);
        return new Page(fatherMenu,fatherMenuCount);
    }

    /**添加父菜单
     * @param permission
     * @return
     */
    @Override
    public int addFatherMenu(Permission permission) {
        return menuMapper.addFatherMenu(permission);
    }

    /**修改父菜单信息
     * @param permission
     * @return
     */
    @Override
    public int updateFatherMenu(Permission permission) {
        return menuMapper.updateFatherMenu(permission);
    }

    /**删除父菜单与其下方的子菜单
     * @param id
     * @return
     */
    @Override
    public int deleteFatherMenu(Integer id) {
        return menuMapper.deleteFatherMenu(id);
    }

    /**获取子菜单
     * @param permission
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page getSonMenu(Permission permission, int currentPage, int pageSize) {
        RowBounds rowBounds=new RowBounds((currentPage-1) * pageSize,pageSize);
        List<Permission> sonMenu = menuMapper.getSonMenu(permission, rowBounds);
        int sonMenuCount = menuMapper.SonMenuCount(permission);
        return new Page(sonMenu,sonMenuCount);
    }

    /**添加子菜单
     * @param permission
     * @return
     */
    @Override
    public int addSonMenu(Permission permission) {
        return menuMapper.addSonMenu(permission);
    }

    /**修改子菜单信息
     * @param permission
     * @return
     */
    @Override
    public int updateSonMenu(Permission permission) {
        return menuMapper.updateSonMenu(permission);
    }

    /**删除子菜单
     * @param id
     * @return
     */
    @Override
    public int deleteSonMenu(Integer id) {
        return menuMapper.deleteSonMenu(id);
    }


}
