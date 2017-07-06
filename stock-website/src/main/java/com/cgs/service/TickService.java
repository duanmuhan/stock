package com.cgs.service;

import com.cgs.dao.TickDao;
import com.cgs.entity.graphs.Tick;
import com.cgs.vo.TickRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class TickService {

    @Autowired
    private TickDao tickDao;

    public List<Tick> findTickById(TickRequest request){
        List<Tick> tickList = tickDao.findTickListById(request.getStockId(),request.getBegin(),request.getEnd());
        return tickList;
    }
}
