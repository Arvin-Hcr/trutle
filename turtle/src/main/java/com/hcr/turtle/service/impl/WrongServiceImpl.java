package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.Wrong;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.mapper.WrongMapper;
import com.hcr.turtle.service.WrongService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:WrongServiceImpl
 * author:Qiao
 * createTime:2019/7/31
 * version:1.0.0
 */
@Service
public class WrongServiceImpl implements WrongService {
    @Autowired
    private WrongMapper mapper;
    @Override
    public Page wrongList(Wrong wrong, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<Wrong> list = mapper.wrongList(wrong, rowBounds);
        Integer count = mapper.wrongCount(wrong);
        return new Page(list,count);
    }

    @Override
    public Integer updateWrong(Integer id) {
        return mapper.updateWrong(id);
    }

    @Override
    public Page wrong2List(Wrong wrong, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<Wrong> list = mapper.wrong2List(wrong, rowBounds);
        Integer count = mapper.wrong2Count(wrong);
        return new Page(list,count);
    }

    @Override
    public Integer saveWrong(Map map) {
        return mapper.saveWrong(map);
    }
}
