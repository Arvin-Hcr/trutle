package com.hcr.turtle.service;

import com.hcr.turtle.entiey.PaidHouse;
import com.hcr.turtle.entiey.Rented;
import com.hcr.turtle.util.Page;

public interface PaidService {

    /**
     * 获取全部已出租房源信息，从rented中获取
     */
    Page RentedList(Rented rented, int current, int pageSize);

    /**
     * 往paid表里面录入租客
     */
    int insertPaid(PaidHouse paidHouse);

    /**
     * 获取全部待缴租金租房源信息，从rented中获取
     */
    Page NoPaidList(PaidHouse paidHouse, int current, int pageSize);

    /**
     * 获取全部已缴租金租房源信息，从rented中获取
     */
    Page YetPaidList(PaidHouse paidHouse, int current, int pageSize);

    /**
     * 获取全部待缴租金租房源信息，从paid中获取
     */
    Page staypaid(PaidHouse paidHouse, int current, int pageSize);

    /**
     * 获取全部已缴租金租房源信息，从paid中获取
     */
    Page havepaid(PaidHouse paidHouse, int current, int pageSize);
    /**
     *更改为交租状态为2
     */
    int upLessState(Integer id);


}
