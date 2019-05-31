package com.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    private final Logger logger= LoggerFactory.getLogger(testController.class);
    @GetMapping("log")
    public String log()
    {
        logger.error("假装出错");
        return "查看log文件，是否有新的打印";
    }

}
