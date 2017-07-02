package com.cgs.service;

import com.cgs.dao.KLineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/2.
 */
@Service
public class KQueryService {

    @Autowired
    private KLineDao kLineDao;

}
