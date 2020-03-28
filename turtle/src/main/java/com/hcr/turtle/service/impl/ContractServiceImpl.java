package com.hcr.turtle.service.impl;

import com.hcr.turtle.mapper.ContractMapper;
import com.hcr.turtle.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ContractServiceImpl
 * @Author Libbly
 * @Date 2019/7/26 21:22
 */
@Service
@SuppressWarnings("all")
public class ContractServiceImpl implements ContractService {
    //引用dao
    @Autowired
    ContractMapper contractMapper;

    @Override
    public List<Map<String, Object>> getContract(Integer hid) {
        return contractMapper.getContract(hid);
    }




}
