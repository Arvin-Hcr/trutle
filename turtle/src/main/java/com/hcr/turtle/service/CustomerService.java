package com.hcr.turtle.service;

import com.hcr.turtle.entiey.CusState;
import com.hcr.turtle.entiey.Customer;
import com.hcr.turtle.util.Page;

import java.util.List;


/**
 * 客户操作
 */
public interface CustomerService {

    /**获取所有员工
     * @param customer
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page getAllCus(Customer customer, int currentPage, int pageSize);

    /**添加员工
     * @param customer
     * @return
     */
    public int addCus(Customer customer);

    /**修改员工信息
     * @param customer
     * @return
     */
    public int updateCus(Customer customer);

    /**
     * 获取所有客户状态
     */
    public List<CusState> getCusState();

    /**
     * 获取所有用户(下拉框)
     */
    public List<Customer> getAll();

    /**
     * 根据ID获取用户信息
     */
    public Customer getCusInfo(Integer id);

    /**
     * 个人中心
     * 从Session中取出用户信息
     */
    public Customer getCusFromSession();

    /**
     *  个人中心
     * 修改用户头像
     */
    public int updateCusImg(Customer customer);

}
