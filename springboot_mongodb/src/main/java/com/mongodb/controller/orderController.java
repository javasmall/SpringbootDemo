package com.mongodb.controller;

import com.mongodb.pojo.logistics;
import com.mongodb.pojo.order;
import com.mongodb.service.orderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class orderController {
    private static Logger logger= LoggerFactory.getLogger(orderController.class);

    @Autowired
    orderService orderService;
    @PostMapping("addorder")
    public String addorder(order order)
    {
        order.setStatus("发货中");
        order.setOrderTime(new Date());
        order.setShipTime(new Date());
        orderService.addorder(order);
        return "添加成功";
    }

    @PostMapping("updateorder")
    public String updateorder(logistics logistics)
    {
       logistics.setOperationTime(new Date());
       orderService.addLogisticsAndUpdateStatus(logistics);
        return "添加成功";
    }

    @GetMapping("getorderbyid")
    public order getOrderById(int id)
    {
        order order=orderService.getOrderById(id);
        return  order;
    }
    @GetMapping("deletebyid")
    public String deleteById(int id)
    {
        orderService.deleteOrderById(id);
        return "成功";
    }
    @GetMapping("getallorders")
    public Map<String,Object> getAllOrder()
    {
        Map<String,Object>map=new HashMap<>();
        List<order> list=orderService.getAllorder();
        map.put("code","0");
        map.put("count",list.size());
        map.put("data",list);
        return  map;
    }

}
