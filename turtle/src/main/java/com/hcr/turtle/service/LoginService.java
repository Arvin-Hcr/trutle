package com.hcr.turtle.service;

import com.hcr.turtle.entiey.Customer;
import com.hcr.turtle.entiey.CustomerAPP;
import com.hcr.turtle.entiey.Employee;

/**
 * 登录
 */
public interface LoginService {

/*=====================================客户登录部分(开始)=====================================*/

    /**登录
     * @param customer
     * @return
     */
    public Customer cusLogin(Customer customer);

    /**判断是否登录
     * @return
     */
    public Customer judgeCusLogin();

    /**检测手机号获取验证码
     * @param customer
     * @return
     */
    public Customer getUsableGetPhone(Customer customer);

    /**用户注册
     * @param customer
     * @return
     */
    public int registerCus(Customer customer, String code);

    /**用户注册APP
     * @param customerAPP
     * @return
     */
    public int registerCusAPP(CustomerAPP customerAPP, String code);



/*=====================================客户登录部分(结束)=====================================*/

/*=====================================员工登录部分(开始)=====================================*/

    /**员工登录
     * @param employee
     * @return
     */
    public Employee empLogin(Employee employee);

    /**判断员工是否登录
     * @return
     */
    public Employee judgeEmpLogin();

/*=====================================员工登录部分(开始)=====================================*/

}
