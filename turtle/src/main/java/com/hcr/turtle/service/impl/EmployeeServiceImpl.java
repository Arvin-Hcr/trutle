package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.EmpState;
import com.hcr.turtle.entiey.Employee;
import com.hcr.turtle.entiey.Role;
import com.hcr.turtle.mapper.EmployeeMapper;
import com.hcr.turtle.util.EmpUtil;
import com.hcr.turtle.util.OtherUtil;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.service.EmployeeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工
 */
@Service
@SuppressWarnings("all")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**获取所有员工
     * @param employee
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page getAllEmp(Employee employee, int currentPage, int pageSize) {
        RowBounds rowBounds=new RowBounds((currentPage-1) * pageSize,pageSize);
        List<Employee> employees=employeeMapper.getAllEmp(employee,rowBounds);
        int count = employeeMapper.empCount(employee);
        return new Page(employees,count);
    }

    /**添加员工
     * @param employee
     * @return
     */
    @Override
    public int addEmp(Employee employee) {
        employee.setEpassword(OtherUtil.MD5(employee.getEusername()));
        return employeeMapper.addEmp(employee);
    }

    /**修改员工信息
     * @param employee
     * @return
     */
    @Override
    public int updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    /**获取角色(下拉框)
     * @return
     */
    @Override
    public List<Role> getRole() {
        List<Role> role = employeeMapper.getRole();
        if (role!=null){
            return role;
        }
        return null;
    }

    /**获取所有员工状态(下拉框)
     * @return
     */
    @Override
    public List<EmpState> getEmpState() {
        List<EmpState> empState = employeeMapper.getEmpState();
        if (empState!=null){
            return empState;
        }
        return null;
    }

    /**根据id查找对应员工信息
     * @return
     */
    @Override
    public List<Employee> getEmpByid() {
        return employeeMapper.getEmpByid(EmpUtil.getEmpFromSession().getId());
    }

    /**根据员工id修改个人信息
     * @param employee
     * @return
     */
    @Override
    public int upEmpnewsByid(Employee employee) {
        employee.setId(EmpUtil.getEmpFromSession().getId());
        return employeeMapper.upEmpnewsByid(employee);
    }

    /**根据id修改员工头像
     * @param employee
     * @return
     */
    @Override
    public int upEmpimgByid(Employee employee) {
        employee.setId(EmpUtil.getEmpFromSession().getId());
        return employeeMapper.upEmpimgByid(employee);
    }

    /**根据id修改员工密码
     * @param employee
     * @return
     */
    @Override
    public int upEmpPswByid(Employee employee) {
        employee.setId(EmpUtil.getEmpFromSession().getId());
        employee.setEpassword(OtherUtil.MD5(employee.getEpassword()));
        return employeeMapper.upEmpPswByid(employee);
    }


}
