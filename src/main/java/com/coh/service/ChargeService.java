package com.coh.service;

import com.coh.mapper.ChargeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeService {
    @Autowired
    private ChargeDao chargeDao;
    public String doCharge(){
        return chargeDao.doCharge();
    }
}
