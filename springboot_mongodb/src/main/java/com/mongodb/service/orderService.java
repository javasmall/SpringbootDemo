package com.mongodb.service;

import com.mongodb.pojo.logistics;
import com.mongodb.pojo.order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    private static Logger logger= LoggerFactory.getLogger(orderService.class);
    @Autowired
    MongoTemplate mongoTemplate;

    //创建订单，传来order对象
    public  void addorder(order order)
    {
        mongoTemplate.insert(order,"order");
    }

    //更新物流
    public  void addLogisticsAndUpdateStatus(logistics logistics)
    {
        String status=logistics.getOperation();
        Query query = new Query(Criteria.where("_id").is(logistics.getOrderId()));

        Update update = new Update();
        update.set("status", status);//更新状态
        update.push("logistics",logistics);

        mongoTemplate.upsert(query, update, order.class,"order");
    }

    //通过id查询物流
    public order getOrderById(int id)
    {
        Query query = new Query(Criteria.where("_id").is(id));
        order order=mongoTemplate.findOne(query, order.class,"order");

        return  order;
    }
    //根据id删除记录
    public boolean deleteOrderById(int id)
    {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,order.class,"order");
        return  true;
    }
    //查询所有订单
    public List<order>getAllorder()
    {
        List<order>list=mongoTemplate.findAll(order.class,"order");
        return  list;
    }

}
