package com.hcr.turtle.service;


import java.util.List;
import java.util.Map;

public interface ChartService {
    /**
     * 算出每月租出的房屋总数
     */
    List rentOutNumber(String year);


    List<Map> rentedchart(Map map);


}
