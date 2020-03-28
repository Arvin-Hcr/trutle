package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.House;
import com.hcr.turtle.entiey.Rented;
import com.hcr.turtle.entiey.Seehistory;
import com.hcr.turtle.mapper.HouseMapper;
import com.hcr.turtle.util.CusUtil;
import com.hcr.turtle.util.EmpUtil;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.mapper.NewHouseMapper;
import com.hcr.turtle.service.NewHouseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("all")
@Service
public class NewHouseServiceImpl implements NewHouseService {

    @Autowired
    private NewHouseMapper newHouseMapper;
    @Autowired
    private HouseMapper houseMapper;

    /**预约看房
     * @param id
     * @returnrentHouse
     */
    @Override
    public int addHosofCus(Integer id) {
        Seehistory seehistory=new Seehistory();
        seehistory.setRenter(CusUtil.getCusFromSession().getId());
        seehistory.setHouseid(id);
        return newHouseMapper.addHosofCus(seehistory);
    }

    /**获取对应经纪人的房源(已发布)
     * @param house
     * @param current
     * @param pageSize
     * @return
     */
    @Override
    public Page getEmpHos(House house, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        house.setAgentid(EmpUtil.getEmpFromSession().getId());
        List<House> list = newHouseMapper.getEmpHos(house, rowBounds);
        for (House h : list) {
            Integer id = h.getHouseid();
            Integer hid=h.getId();
            //System.out.println("房子id"+hid);
            Integer lessCount = newHouseMapper.getLessCount(hid);
            //System.out.println("预约人数:"+lessCount);
            h.setLesscount(lessCount);
            List<String> lableList = houseMapper.lableList(id);
            h.setDesctag(lableList);
            List<String> houseInstallation = houseMapper.houseInstallation(id);
            h.setInstallation(houseInstallation);
        }
        Integer count = newHouseMapper.EmpHosCount(house);
        return new Page(list, count);
    }

    /**根据房源id获取对应预约人资料
     * @param id
     * @return
     */
    @Override
    public List<Seehistory> getLessByHosId(Integer id) {
        return newHouseMapper.getLessByHosId(id);
    }

    /**修改客户预约信息(已看房)
     * @param id
     * @return
     */
    @Override
    public int upLessState(Integer id) {
        return newHouseMapper.upLessState(id);
    }

    /**根据id修改看房记录
     * @param seehistory
     * @return
     */
    @Override
    public int upCusAndSee(Seehistory seehistory) {
        //Object seetime = seehistory.getSeetime();
        //System.out.println("时间:"+seetime);
        int i = newHouseMapper.upCusCardByid(seehistory);
        int i1 = newHouseMapper.upSeeByid(seehistory);
        if (i > 0 && i1 > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**租房
     *
     * @param rented
     * @return
     */
    @Override
    public int rentHouse(Rented rented) {
        //在rented表里面添加一条租房信息
        int insertRented = newHouseMapper.insertRented(rented);
        Integer tenantid = rented.getRenter();
        Integer houseid = rented.getHouseid();
        //根据ID修改已发布的房屋状态为已出租(4)
        //给house表补充租客的ID（house中的tenantid）
        int updateThree = newHouseMapper.updateThree(tenantid, houseid);
        //根据房子id删除看房记录
        //删除seehistory表中对应的数据
        int deleSee = newHouseMapper.deleSee(houseid);
        if (insertRented > 0 && houseid > 0 && deleSee >0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**根据用户id删除看房记录
     * @param id
     * @return
     */
    @Override
    public int deleSeeByCusId(Integer id) {
        return newHouseMapper.deleSeeByCusId(id);
    }


}
