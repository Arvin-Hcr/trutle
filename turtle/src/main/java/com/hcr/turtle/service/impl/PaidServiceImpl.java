package com.hcr.turtle.service.impl;

import com.hcr.turtle.entiey.PaidHouse;
import com.hcr.turtle.entiey.Rented;
import com.hcr.turtle.util.CusUtil;
import com.hcr.turtle.util.Page;
import com.hcr.turtle.mapper.PaidMapper;
import com.hcr.turtle.service.PaidService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *fileName:PaidServiceImpl
 *description:
 *author:周铎
 *createTime:2019-07-29 19:32
 *version：1.0.0
 */
@Service
@SuppressWarnings("all")
public class PaidServiceImpl implements PaidService {

    @Autowired
    private PaidMapper paidMapper;


    @Override
    public Page RentedList(Rented rented, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<Rented> renteds=paidMapper.getAllRented(rented, rowBounds);

        Integer count = paidMapper.BackListcount(rented);
        return new Page(renteds,count);
    }

    @Override
    public int insertPaid(PaidHouse paidHouse) {
         int insertPaid = paidMapper.insertPaid(paidHouse);
        if (insertPaid > 0 ) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Page NoPaidList(PaidHouse paidHouse, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<PaidHouse> paidHouses=paidMapper.getNoPaid(paidHouse, rowBounds);

        Integer count = paidMapper.BackListpaid(paidHouse);
        return new Page(paidHouses,count);
    }


    @Override
    public Page YetPaidList(PaidHouse paidHouse, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<PaidHouse> paidHouses=paidMapper.getYetPaid(paidHouse, rowBounds);

        Integer count = paidMapper.BackListYetpaid(paidHouse);
        return new Page(paidHouses,count);
    }


    @Override
    public Page staypaid(PaidHouse paidHouse, int current, int pageSize) {
        Integer tenantid = CusUtil.getCusFromSession().getId();
        //System.out.println(tenantid);
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<PaidHouse> paidHouses=paidMapper.staypaid(paidHouse, rowBounds,tenantid);
        Integer count = paidMapper.staynupaid(paidHouse,tenantid);
        return new Page(paidHouses,count);
    }


    @Override
    public Page havepaid(PaidHouse paidHouse, int current, int pageSize) {
        Integer tenantid = CusUtil.getCusFromSession().getId();
        //System.out.println(tenantid);
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<PaidHouse> paidHouses=paidMapper.havepaid(paidHouse, rowBounds,tenantid);
        Integer count = paidMapper.havenupaid(paidHouse,tenantid);
        return new Page(paidHouses,count);
    }

    @Override
    public int upLessState(Integer id) {
        return paidMapper.updaterent(id);
    }




}
