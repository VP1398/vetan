package com.vetan.controller;

import com.vetan.dto.CustomerData;
import com.vetan.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @RequestMapping("/cusotmersMain")
    public String customerMainPage(){

        return "customerMain";

    }

    @ResponseBody
    @RequestMapping("/")
    public List<CustomerData> getCusotmers(){
        List<CustomerData> customers = customerService.getAllCustomers();
        return  customers;
    }

}
