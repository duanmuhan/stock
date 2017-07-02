package com.cgs.http.controller;

import com.cgs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/25.
 */
@RestController
public class DataController {
    @Autowired
    CompanyService companyService;

}
