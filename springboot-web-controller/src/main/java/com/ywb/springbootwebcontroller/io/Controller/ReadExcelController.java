package com.ywb.springbootwebcontroller.io.Controller;

import com.ywb.springbootwebservice.io.service.ReadExcelService;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadExcelController {

    private static final Logger log = LoggerFactory.getLogger(ReadExcelController.class);

    @Autowired
    private ReadExcelService readExcelService;

    @RequestMapping("readExcel")
    public String readExcel(){

        log.info("readExcelController is beginning ...");
        try {
            readExcelService.readExcel();
        }catch (Exception e) {
            log.error("调用失败：" + e.getMessage());
        }
        return "success";
    }
}
