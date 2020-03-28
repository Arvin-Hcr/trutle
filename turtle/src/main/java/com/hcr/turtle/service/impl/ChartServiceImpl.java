package com.hcr.turtle.service.impl;

import com.hcr.turtle.service.ChartService;
import com.hcr.turtle.util.EmpUtil;
import com.hcr.turtle.mapper.ChartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class ChartServiceImpl implements ChartService {
    @Autowired
    ChartMapper chartMapper;

    /**
     * 算出每月租出的房屋总数
     */
    @Override
    public List rentOutNumber(String year) {
        String yearMonth="";
        ArrayList<Object> list = new ArrayList<>();

        Integer id = EmpUtil.getEmpFromSession().getId();

        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                HashMap<String, Object> allHashMap = new HashMap<>();

                yearMonth = year + "-0" + i;
                allHashMap.put("date",yearMonth);
                allHashMap.put("All",chartMapper.rentOutNumber(yearMonth));
                allHashMap.put("My",chartMapper.myRentOutNumber(yearMonth,id));

                list.add(allHashMap);
            } else {
                HashMap<String, Object> allHashMap = new HashMap<>();

                yearMonth = year + "-0" + i;
                allHashMap.put("date",yearMonth);
                allHashMap.put("All",chartMapper.rentOutNumber(yearMonth));
                allHashMap.put("My",chartMapper.myRentOutNumber(yearMonth,id));

                list.add(allHashMap);
            }
        }
        return list;
    }

    @Override
    public List<Map> rentedchart(Map map) {
        //System.out.println(chartMapper.rentedchart(map));
        return chartMapper.rentedchart(map);
    }


}
