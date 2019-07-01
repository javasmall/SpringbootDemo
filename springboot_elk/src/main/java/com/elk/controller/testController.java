package com.elk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    private final static Logger logger= LoggerFactory.getLogger(testController.class);
    @GetMapping("test1")
    public String test1()
    {
        int index=0;
        for(int i=0;i<15;i++)
        {
            logger.info("hello");
            logger.debug("debug"+i);

        }
        logger.error("error");
        logger.warn("warn");
        return "666";
    }

}
