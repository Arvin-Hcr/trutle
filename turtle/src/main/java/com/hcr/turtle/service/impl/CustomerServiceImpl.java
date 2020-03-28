package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.CusState;
import com.hcr.turtle.entiey.Customer;
import com.hcr.turtle.mapper.CustomerMapper;
import com.hcr.turtle.util.CusUtil;
import com.hcr.turtle.util.OtherUtil;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.service.CustomerService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户操作
 */
@Service
@SuppressWarnings("all")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**获取所有客户
     * @param customer
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page getAllCus(Customer customer, int currentPage, int pageSize) {
        RowBounds rowBounds=new RowBounds((currentPage-1) * pageSize,pageSize);
        List<Customer> customers=customerMapper.getAllCus(customer,rowBounds);
        int count = customerMapper.cusCount(customer);
        return new Page(customers,count);
    }

    /**添加客户
     * @param customer
     * @return
     */
    @Override
    public int addCus(Customer customer) {
        customer.setCnumber(OtherUtil.GetCnum());
        customer.setCusername(OtherUtil.getUname());
        customer.setCpassword(OtherUtil.MD5("000000"));
        return customerMapper.addCus(customer);
    }

    /**修改客户信息
     * @param customer
     * @return
     */
    @Override
    public int updateCus(Customer customer) {
        return customerMapper.updateCus(customer);
    }

    /**获取客户状态
     * @return
     */
    @Override
    public List<CusState> getCusState() {
        return customerMapper.getCusState();
    }

    @Override
    public List<Customer> getAll() {
        return customerMapper.getAll();
    }

    @Override
    public Customer getCusInfo(Integer id) {
        return customerMapper.getCusInfo(id);
    }

    //
    @Override
    public Customer getCusFromSession() {
        return CusUtil.getCusFromSession();
    }

    @Override
    public int updateCusImg(Customer customer) {
        Integer id = CusUtil.getCusFromSession().getId();
        customer.setId(id);
        return customerMapper.updateCusImg(customer);
    }

}
