package com.cgs.service;

import com.cgs.dao.ValuableCompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/25.
 */
@Service
public class ValuableCompanyService {

    @Autowired
    private ValuableCompanyDao valuableCompanyDao;

}
