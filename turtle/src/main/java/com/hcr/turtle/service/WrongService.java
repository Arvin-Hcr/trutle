package com.hcr.turtle.service;

import com.hcr.turtle.entiey.Wrong;
import com.hcr.turtle.util.Page;

import java.util.Map;


/**
 * fileName:WrongService
 * author:Qiao
 * createTime:2019/7/31
 * version:1.0.0
 */
public interface WrongService {
    /**
     * 查询所有未处理报障的房屋列表
     * @param wrong
     * @param current
     * @param pageSize
     * @return
     */
    Page wrongList(Wrong wrong, int current, int pageSize);

    /**
     * 根据id修改房屋的处理状态
     * @param id
     * @return
     */
    Integer updateWrong(Integer id);

    /**
     * 查询所有已处理报障的房屋列表
     * @param wrong
     * @param current
     * @param pageSize
     * @return
     */
    Page wrong2List(Wrong wrong, int current, int pageSize);

    /**
     * 添加报修的信息
     * @param map
     * @return
     */
    Integer saveWrong(Map map);
}
