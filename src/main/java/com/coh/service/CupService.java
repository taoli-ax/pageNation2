package com.coh.service;

import com.coh.pojo.Cup;
import com.coh.pojo.Page;

import java.util.List;

public interface CupService {
    List<Cup> queryCupByName();
    List<Cup> findAll();

    List<Cup> FindByPage(Page page);

    /**
     * 按照查询条件查询
     * @param page page类
     * @param cupBrand 查询条件
     * @param cupName 查询条件
     * @return
     */
    List<Cup> QueryByPage(Page page, String cupBrand, String cupName);

}
