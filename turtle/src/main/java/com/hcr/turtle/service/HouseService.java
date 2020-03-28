package com.hcr.turtle.service;

import com.hcr.turtle.entiey.*;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.util.Result;

import java.util.List;
import java.util.Map;


public interface HouseService {
    /**
     * 获取全部已发布的房屋列表
     */
    Page houseList(House house, int current, int pageSize);

    /**
     * 后台数据表格获取全部房屋列表
     */
    Page houseBackList(House house, int current, int pageSize);

    /**获取所有房屋状态
     * @return
     */
    List<HouseState> getAllHosState();

    /**获取所有联系房源
     * @param leadHouse
     * @return
     */
    Page getAllLeadhouse(LeadHouse leadHouse, int current, int pageSize);

    /**
     * 根据ID修改leadhouse房源状态为已联系(1)
     */
    Integer updateLstate(Integer id);

    /**
     * 根据ID获取房屋详细信息
     */
    Map<String, Object> houseDetail(Integer id);

    /**sun
     * 查询所有客户信息
     */
    List<Customer> cnumberAll();

    /**sun
     * 根据房东编号cnumber查询房东id
     */
    Integer cnumberById(Integer cnumber);

    /**sun
     * 获取登录的经纪人信息
     */
    Employee employeeSession();

    /**sun
     * 往house_furniture房屋设施中间表中添加数据
     */
    Result housefurInsert(Integer houseid, String[] furniture);

    /**sun
     * 往house_label房屋设施中间表中添加数据
     */
    Result houselabelInsert(Integer houseid, String[] labels);

    /**sun
     * 根据cnumber房东编号修改customer表中房东信息
     */
    Integer updateCustomer(Customer customer);

    /**sun
     * 往house表中插入房源信息
     */
    Integer houseInsert(House house);

    /**
     * sun
     * 根据房屋id查询房屋记录，验证房屋id是否重复
     */
    Result houseById(Integer houseid);

    /**sun
     * 往leadhouse表中添加发布房源信息
     */
    Integer leadhouseInsert(LeadHouse leadHouse);

    /**sun
     * 往houseimgs表中插入房屋组图路径
     */
    Integer houseimgsInsert(HouseImgs houseImgs);

    /**
     * 根据ID删除房屋信息
     */
    int delHouseById(Integer id);

    /**
     * 根据ID修改房源信息
     */
    int updateHouseInfo(Houses house);

    /**
     * 获取待审核房源
     */
    Page unauditedHouse(House house, int current, int pageSize);

    /**
     * 更改待审核的房源状态为已审核(4)
     */
    int updateStateOne(Integer id);

    /**
     * 更改待审核的房源状态为未通过(3)
     */
    int updateStateTwo(House house);

    /**
     * 更改已审核的房源状态为已发布(0)
     */
    int updateStateThree(Integer id);

    /**
     * 更改已发布的房源状态为待发布(1)
     */
    int updateStateFour(Integer id);

    /**
     * 根据ID修改房源信息(再次提交)
     * @param house
     */
    int updateTwoHouse(House house);

    /**
     * 获取对应经纪人的房源
     */
    Page agentHouse(House house, int current, int pageSize);

    /**获取房客
     * @param id
     * @return
     */
    List<RentedandCus> getAllRenCus(Integer id);

    /**
     * 关注房源
     */
    int followhouse(Integer houseid);

    /**
     * 判断是否已经关注
     */
    FollowHouse isFollow(Integer houseid);

    /**
     * 用户关注的房源
     */
    Page myFollowHouse();

    /**
     * 取消关注
     */
    int delFollow(Integer houseid);

    /**
     * 用户发布的房源
     */
    Page myPostedHouse();

    /**
     * 根据房屋ID获取对应的配套设施
     */
    List<String> houseInstallation(Integer houseid);

    /**
     * 当前用户名下租赁的房子（乔 新增）
     * @return
     */
    Page myRentHouse();

    /**
     * 查询报修填写的信息
     * @param id
     * @return
     */
    Map myRepairs(Integer id);

}
