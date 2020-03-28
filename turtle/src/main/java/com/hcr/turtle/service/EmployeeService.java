package com.hcr.turtle.service;

import com.hcr.turtle.entiey.EmpState;
import com.hcr.turtle.entiey.Employee;
import com.hcr.turtle.entiey.Role;
import com.hcr.turtle.util.Page;

import java.util.List;

/**
 * 员工
 */
public interface EmployeeService {

    /**获取所有员工
     * @param employee
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page getAllEmp(Employee employee, int currentPage, int pageSize);

    /**添加员工
     * @param employee
     * @return
     */
    public int addEmp(Employee employee);

    /**修改员工信息
     * @param employee
     * @return
     */
    public int updateEmp(Employee employee);


    /**获取角色(下拉框)
     * @return
     */
    public List<Role> getRole();

    /**获取所有员工状态(下拉框)
     * @return
     */
    public List<EmpState> getEmpState();

    /**根据员工id查找对应信息
     * @return
     */
    public List<Employee> getEmpByid();


    /**根据员工id修改个人信息
     * @param employee
     * @return
     */
    public int upEmpnewsByid(Employee employee);


    /**根据id修改员工头像
     * @param employee
     * @return
     */
    public int upEmpimgByid(Employee employee);

    /**根据员工id修改密码
     * @param employee
     * @return
     */
    public int upEmpPswByid(Employee employee);
}
