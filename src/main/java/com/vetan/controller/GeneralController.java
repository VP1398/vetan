package com.vetan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class troller {

    @RequestMapping(value = "employerdash")
    public String dashboardPage(){
        return "employerdash";
    }
   
    @RequestMapping(value = "employeedash")
    public String employeePage(){
        return "employeedash";
    }
    @RequestMapping(value = "statutory")
    public String statutoryPage(){
        return "statutory";
    }

    @RequestMapping(value = "pension")
    public String pensionPage(){
        return "pension";
    }
    @RequestMapping(value = "Gratuity")
    public String GratuityPage(){
        return "Gratuity";
    }
    @RequestMapping(value = "PF")
    public String PFPage(){
        return "PF";
    }
   
    @RequestMapping(value = "it")
        public String itPage(){
            return "it";
    }
       
    @RequestMapping(value = "others")
        public String othersPage(){
            return "others";
        }
    
  
    @RequestMapping(value = "mydashboard")
    public String mydashboardPage(){
        return "mydashboard";
    }
    

    @RequestMapping(value = "claim")
    public String claimPage(){
        return "claim";
    }
    

    @RequestMapping(value = "tracker")
    public String trackerPage(){
        return "tracker";
    }
    

    @RequestMapping(value = "nominee")
    public String nomineePage(){
        return "nominee";
    }
    

    @RequestMapping(value = "form16")
    public String form16Page(){
        return "form16";
    }
}

