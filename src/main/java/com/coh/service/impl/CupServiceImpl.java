package com.coh.service.impl;

import com.coh.dao.CupDao;
import com.coh.pojo.Cup;
import com.coh.pojo.CupExample;
import com.coh.pojo.Page;
import com.coh.service.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CupServiceImpl implements CupService {
    @Autowired
    private CupDao cupDao;


    public CupServiceImpl(CupDao cupDao) {
        this.cupDao = cupDao;
    }

    public void setCupDao(CupDao cupDao) {
        this.cupDao = cupDao;
    }

    @Override
    public List<Cup> queryCupByName() {
        return cupDao.selectByExample(null);

    }

    @Override
    public List<Cup> findAll() {
        return cupDao.selectByExample(null);
    }

    @Override
    public List<Cup> FindByPage(Page page) {
        // Page对象 查询并设置总行数
        long lines =cupDao.countByExample(null);
        page.setCountRow((int) lines);
        // Page对象 计算总页数
        int totalPage=page.getCountRow()%page.getPageSize()==0? page.getCountRow()/page.getPageSize() :page.getCountRow()/ page.getPageSize()+1;
        page.setCountPage(totalPage);

        CupExample example=new CupExample();
        //设置查询条件：根据当前页号码，应该获展示多少条数据 每页的有多少数据
        example.setOffset((long) ((long) (page.getPageNum() - 1) *page.getPageSize()));
        example.setLimit(page.getPageSize());

        return cupDao.selectByExample(example);
    }

    @Override
    public List<Cup> QueryByPage(Page page, String cupBrand, String cupName) {
        CupExample cupExample=new CupExample();
        CupExample.Criteria criteria=cupExample.createCriteria();
        if(cupBrand!=null && !"".equals(cupBrand)){
            criteria.andBrandLike("%"+cupBrand+"%");
        }
        if(cupName!=null && !"".equals(cupName)){
            criteria.andNameLike("%"+cupName+"%");
        }


        // Page对象 查询并设置总行数
        long lines =cupDao.countByExample(cupExample);
        page.setCountRow((int) lines);
        // Page对象 计算总页数
        int totalPage=page.getCountRow()%page.getPageSize()==0? page.getCountRow()/page.getPageSize() :page.getCountRow()/ page.getPageSize()+1;
        page.setCountPage(totalPage);

        //设置查询条件：根据当前页号码，应该获展示多少条数据 每页的有多少数据
        cupExample.setOffset((long) ((long) (page.getPageNum() - 1) *page.getPageSize()));
        cupExample.setLimit(page.getPageSize());

        return cupDao.selectByExample(cupExample);
    }


}
