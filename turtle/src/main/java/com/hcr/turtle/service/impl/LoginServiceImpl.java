package com.hcr.turtle.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hcr.turtle.entiey.Customer;
import com.hcr.turtle.entiey.CustomerAPP;
import com.hcr.turtle.entiey.Employee;
import com.hcr.turtle.mapper.CustomerMapper;
import com.hcr.turtle.mapper.EmployeeMapper;
import com.hcr.turtle.util.CusUtil;
import com.hcr.turtle.util.EmpUtil;
import com.hcr.turtle.util.OtherUtil;
import com.hcr.turtle.util.SmsUtil;
import com.hcr.turtle.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录
 */
@Service
@SuppressWarnings("all")
public class LoginServiceImpl implements LoginService {

/*=====================================客户登录部分(开始)=====================================*/

    Customer cussession=null; //用户信息
    String codenum=null; //手机验证码

    @Autowired
    private CustomerMapper customerMapper;



    /**
     * 登录
     *
     * @param customer
     * @return
     */
    public Customer cusLogin(Customer customer) {
        customer.setCpassword(OtherUtil.MD5(customer.getCpassword()));
        Customer login = customerMapper.cusLogin(customer);
        if (login!=null){
            CusUtil.saveCus(login);
            return login;
        }
        return null;
    }

    /**判断是否登录
     * @return
     */
    public Customer judgeCusLogin(){
        cussession=CusUtil.getCusFromSession();
        if(cussession==null){
            return null;
        }
        return cussession;
    }

    /**检测手机号获取验证码
     * @param customer
     * @return
     */
    public Customer getUsableGetPhone(Customer customer){
        Customer customer1= customerMapper.getUsableGetPhone(customer);
        if (customer1!=null){
            return customer1;
        }

        String telephone=customer.getCphone();
        codenum=OtherUtil.getNum();
        //System.out.println("发送的验证码"+codenum);
        try {
            SendSmsResponse sms = SmsUtil.sendSms(telephone,codenum);
            /*System.out.println("Code=" + sms.getCode());
            System.out.println("Message=" + sms.getMessage());
            System.out.println("RequestId=" + sms.getRequestId());
            System.out.println("BizId=" + sms.getBizId());*/
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**用户注册
     * @param customer
     * @return
     */
    public int registerCus(Customer customer,String code){
        System.out.println("验证的code"+code);
        if (code.equals(codenum)){
            if (OtherUtil.isEmpty(customer.getId())){
                customer.setCnumber(OtherUtil.GetCnum());
                customer.setCpassword(OtherUtil.MD5(customer.getCpassword()));
                customer.setCusername(OtherUtil.getUname());
                customerMapper.registerCus(customer);
                return 1;
            }else {
                return 0;
            }
        }
        return -1;
    }

    /**用户注册APP
     * @param customerAPP
     * @return
     */
    public int registerCusAPP(CustomerAPP customerAPP, String code){
        //System.out.println("验证的code"+code);
        if (code.equals(codenum)){
            if (OtherUtil.isEmpty(customerAPP.getId())){
                customerAPP.setCnumber(OtherUtil.GetCnum());
                customerAPP.setCpassword(OtherUtil.MD5(customerAPP.getCpassword()));
                customerAPP.setCusername(OtherUtil.getUname());
                customerMapper.registerCusAPP(customerAPP);
                return 1;
            }else {
                return 0;
            }
        }
        return -1;
    }




/*=====================================客户登录部分(结束)=====================================*/


/*=====================================员工登录部分(开始)=====================================*/


    @Autowired
    private EmployeeMapper employeeMapper;

    Employee employeession=null;//员工信息


    /**员工登录
     * @param employee
     * @return
     */
    @Override
    public Employee empLogin(Employee employee){
        employee.setEpassword(OtherUtil.MD5(employee.getEpassword()));
        Employee empLogin = employeeMapper.empLogin(employee);
        if (empLogin!=null){
            EmpUtil.saveEmp(empLogin);
            return empLogin;
        }
        return null;
    }

    /**判断员工是否登录
     * @return
     */
    @Override
    public Employee judgeEmpLogin() {
        employeession=EmpUtil.getEmpFromSession();
        if(employeession==null){
            return null;
        }
        return employeession;
    }


}
