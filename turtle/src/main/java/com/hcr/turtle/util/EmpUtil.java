package com.hcr.turtle.util;

import com.hcr.turtle.entiey.Employee;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 员工工具类
 */
public class EmpUtil {

    /**取HttpServletRequest
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes att=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return att.getRequest();
    }

    /**获取session
     * @return
     */
    public static HttpSession getSession(){
        HttpSession session=null;
        if (null==session) {
            session=getRequest().getSession();
        }
        return session;
    }

    /**往session中保存登录后的员工信息
     * @param e
     */
    public static void saveEmp(Employee e){
        getSession().setAttribute(ISysConstants.EMP,e);
    }

    /**从session获取员工信息
     * @return
     */
    public static Employee getEmpFromSession(){
        Employee e=(Employee) getSession().getAttribute(ISysConstants.EMP);
        return e;
    }

    /**
     * 退出登录，销毁session
     */
    public static void removeEmployee(){
        getSession().invalidate();
    }

    /**判断是否为超管
     * @return
     */
    public static boolean isAdmin(){
        Employee employee=getEmpFromSession();
        if (null!=employee) {
            if (employee.getRoleid()==1) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
