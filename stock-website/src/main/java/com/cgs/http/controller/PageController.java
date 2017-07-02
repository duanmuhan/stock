package com.cgs.http.controller;

import com.cgs.constant.API;
import com.cgs.constant.PageConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

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

    @RequestMapping(value = API.BLANK,method = RequestMethod.GET)
    public ModelAndView blank(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.BLANK_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_BUTTONS,method = RequestMethod.GET)
    public ModelAndView componentsButtons(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_BUTTONS_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_FORMS,method = RequestMethod.GET)
    public ModelAndView componentsForms(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_FORMS_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_MODALS,method = RequestMethod.GET)
    public ModelAndView componentsModals(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_MODALS_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_SOCIAL_BUTTONS,method = RequestMethod.GET)
    public ModelAndView componentsSocialButtons(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_SOCIAL_BUTTONS_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_SWITCHES,method = RequestMethod.GET)
    public ModelAndView componentsSwitches(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_SWITCHES_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_TABLES,method = RequestMethod.GET)
    public ModelAndView componentsTables(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_TABLES_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.COMPONENTS_TABS,method = RequestMethod.GET)
    public ModelAndView componentsTabs(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.COMPONENTS_TABS_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.ICONS_FONT_AWESOME,method = RequestMethod.GET)
    public ModelAndView iconFontAwesome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.ICONS_FONT_AWESOME_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = API.ICONS_SIMPLE_LINE_ICONS,method = RequestMethod.GET)
    public ModelAndView iconSimpleLineIcons(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PageConstant.ICONS_SIMPLE_LINE_ICONS_PAGE);
        return modelAndView;
    }
}
