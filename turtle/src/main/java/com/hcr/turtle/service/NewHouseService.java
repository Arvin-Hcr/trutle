package com.hcr.turtle.service;

import com.hcr.turtle.entiey.House;
import com.hcr.turtle.entiey.Rented;
import com.hcr.turtle.entiey.Seehistory;
import com.hcr.turtle.util.Page;

import java.util.List;

public interface NewHouseService {

    /**预约看房
     * @param id
     * @return
     */
    public int addHosofCus(Integer id);

    /**
     * 获取对应经纪人的房源(已发布)
     */
    Page getEmpHos(House house, int current, int pageSize);


    /**根据房源id获取对应预约人资料
     * @param id
     * @return
     */
    List<Seehistory> getLessByHosId(Integer id);


    /**修改客户预约信息(已看房)
     * @param id
     * @return
     */
    int upLessState(Integer id);

    /**修改看房记录
     * @param seehistory
     * @return
     */
    int upCusAndSee(Seehistory seehistory);

    /**
     * 房屋出租
     */
    int rentHouse(Rented rented);

    /**根据用户id删除看房记录
     * @param id
     * @return
     */
    int deleSeeByCusId(Integer id);
}
