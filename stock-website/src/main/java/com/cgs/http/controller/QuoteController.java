package com.cgs.http.controller;

import com.cgs.constant.API;
import com.cgs.constant.PageConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuoteController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.MAIN_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.MAIN,method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.MAIN_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.CHART,method = RequestMethod.GET)
    public ModelAndView chart(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.CHART_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPANY_INFO,method = RequestMethod.GET)
    public ModelAndView companyInfo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPANY_INFO_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.WIDGET,method = RequestMethod.GET)
    public ModelAndView widget(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.WIDGET_PAGE);
        return modelAndView;
    }
}
