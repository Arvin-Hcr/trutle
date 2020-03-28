package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.*;
import com.hcr.turtle.mapper.HouseMapper;
import com.hcr.turtle.util.CusUtil;
import com.hcr.turtle.util.EmpUtil;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.util.Result;
import com.hcr.turtle.service.HouseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;


    @Override
    public Page houseList(House house, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<House> list = houseMapper.houseList(house, rowBounds);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        Integer count = houseMapper.count(house);
        return new Page(list, count);
    }

    //所有房源
    @Override
    public Page houseBackList(House house, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<House> list = houseMapper.houseBackList(house, rowBounds);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        Integer count = houseMapper.BackListcount(house);
        return new Page(list, count);
    }

    /**获取所有房屋状态
     * @return
     */
    @Override
    public List<HouseState> getAllHosState() {
        return houseMapper.getAllHosState();
    }

    //
    @Override
    public Page getAllLeadhouse(LeadHouse leadHouse, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<LeadHouse> leadhouse = houseMapper.getAllLeadhouse(leadHouse, rowBounds);
        Integer leaCount = houseMapper.leaCount(leadHouse);
        return new Page(leadhouse,leaCount);
    }

    @Override
    public Integer updateLstate(Integer id) {
        return houseMapper.updateLstate(id);
    }

    @Override
    public Map<String, Object> houseDetail(Integer id) {
        House house = houseMapper.houseDetail(id);
        Map<String, Object> map = new HashMap<>();
        //遍历list获取houseid，根据houseid获取对应描述标签
        Integer houseid = house.getHouseid();
        List<String> lableList = houseMapper.lableList(houseid);
        house.setDesctag(lableList);
        //根据houseid获取对应图片列表
        List<String> imgs = houseMapper.houseImgs(houseid);
        house.setHimgs(imgs);
        //根据房屋ID获取对应的配套设施
        List<String> houseInstallation = houseMapper.houseInstallation(houseid);
        house.setInstallation(houseInstallation);
        Integer agentid = house.getAgentid();
        //根据ID获取经纪人信息
        Employee employee = houseMapper.getAgentInfo(agentid);
        map.put("object", house);
        map.put("empinfo", employee);
        return map;
    }

    @Override
    public List<Customer> cnumberAll() {
        return houseMapper.cnumberAll();
    }

    @Override
    public Integer cnumberById(Integer cnumber) {
        return houseMapper.cnumberById(cnumber);
    }

    //获取经纪人的信息
    @Override
    public Employee employeeSession() {
        EmpUtil empUtil = new EmpUtil();
        return empUtil.getEmpFromSession();
    }

    @Override
    public Result housefurInsert(Integer houseid, String[] furniture) {
        Result result = new Result();
        if(furniture.length!=0) {
            for (String s : furniture) {
                int id = houseMapper.furnitureSelect(s);
                houseMapper.housefurInsert(houseid, id);
            }
            result.setCode(200);
            result.setMsg("添加成功");
            return result;
        }
        result.setCode(100);
        result.setMsg("添加失败");
        return result;
    }

    @Override
    public Result houselabelInsert(Integer houseid, String[] labels) {
        Result result = new Result();
        if(labels.length!=0) {
            for (String s : labels) {
                int id = houseMapper.labelInsert(s);
                houseMapper.houselabelInsert(houseid,id);
            }
            result.setCode(200);
            result.setMsg("添加成功");
            return result;
        }
        result.setCode(100);
        result.setMsg("添加失败");
        return result;
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        return houseMapper.updateCustomer(customer);
    }

    @Override
    public Integer houseInsert(House house) {
        return houseMapper.houseInsert(house);
    }

    @Override
    public Result houseById(Integer houseid) {
        Result result = new Result();
        Integer i=houseMapper.houseById(houseid);
        if(i==0||i.equals("null")){
            result.setCode(100);
            result.setMsg("房屋编号可以使用");
            return result;
        }else {
            result.setCode(200);
            result.setMsg("房屋编号已存在");
            return result;
        }
    }

    @Override
    public Integer leadhouseInsert(LeadHouse leadHouse) {
        return houseMapper.leadhouseInsert(leadHouse);
    }

    //往houseimgs表中插入房屋组图路径
    @Override
    public Integer houseimgsInsert(HouseImgs houseImgs) {
        return houseMapper.houseimgsInsert(houseImgs);
    }

    @Override
    public int delHouseById(Integer id) {
        return houseMapper.delHouseById(id);
    }

    @Override
    public int updateHouseInfo(Houses house) {
        return houseMapper.updateHouseInfo(house);
    }

    @Override
    public Page unauditedHouse(House house, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<House> list = houseMapper.unauditedHouse(house, rowBounds);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        Integer count = houseMapper.unauditCount(house);
        return new Page(list, count);
    }

    @Override
    public int updateStateOne(Integer id) {
        return houseMapper.updateStateOne(id);
    }

    @Override
    public int updateStateTwo(House house) {
        return houseMapper.updateStateTwo(house);
    }

    @Override
    public int updateStateThree(Integer id) {
        return houseMapper.updateStateThree(id);
    }

    @Override
    public int updateStateFour(Integer id) {
        return houseMapper.updateStateFour(id);
    }

    /**
     * 根据ID修改房源信息(再次提交)
     * @param house
     */
    @Override
    public int updateTwoHouse(House house) {
        return houseMapper.updateTwoHouse(house);
    }

    @Override
    public Page agentHouse(House house, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        house.setAgentid(EmpUtil.getEmpFromSession().getId());
        List<House> list = houseMapper.agentHouse(house, rowBounds);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        Integer count = houseMapper.agentHouseCount(house);
        return new Page(list, count);
    }

    /**获取房客
     * @param id
     * @return
     */
    @Override
    public List<RentedandCus> getAllRenCus(Integer id) {
        return houseMapper.getAllRenCus(id);
    }



    @Override
    public int followhouse(Integer houseid) {
        Integer cid = CusUtil.getCusFromSession().getId();
        return houseMapper.followhouse(cid, houseid);
    }

    //判断是否关注
    @Override
    public FollowHouse isFollow(Integer houseid) {
        Integer cid = CusUtil.getCusFromSession().getId();
        return houseMapper.isFollow(cid,houseid);
    }

    @Override
    public Page myFollowHouse() {
        Integer cid = CusUtil.getCusFromSession().getId();
        List<House> list = houseMapper.myFollowHouse(cid);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        int count = houseMapper.myFollowHouseCount(cid);
        return new Page(list,count);
    }

    @Override
    public int delFollow(Integer houseid) {
        Integer cid = CusUtil.getCusFromSession().getId();
        return houseMapper.delFollow(cid,houseid);
    }

    @Override
    public Page myPostedHouse() {
        Integer cid = CusUtil.getCusFromSession().getId();
        List<House> list = houseMapper.myPostedHouse(cid);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        int count = houseMapper.myPostedHouseCount(cid);
        return new Page(list,count);
    }


    /**
     * 根据房屋ID获取对应的配套设施
     */
    @Override
    public List<String> houseInstallation(Integer houseid) {
        return houseMapper.houseInstallation(houseid);
    }

    @Override
    public Page myRentHouse() {
        Integer cid =CusUtil.getCusFromSession().getId();
        List<House> list = houseMapper.myRentHouse(cid);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> lableList = houseMapper.lableList(hid);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        int count = houseMapper.myRentHouseCount(cid);
        return new Page(list,count);
    }

    @Override
    public Map myRepairs(Integer id) {
        return houseMapper.myRepairs(id);
    }




}
