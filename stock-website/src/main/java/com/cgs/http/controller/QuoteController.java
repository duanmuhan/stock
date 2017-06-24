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
}
