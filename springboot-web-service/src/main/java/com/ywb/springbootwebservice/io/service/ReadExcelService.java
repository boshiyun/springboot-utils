package com.ywb.springbootwebservice.io.service;

import com.ywb.springbootwebdao.io.dao.UserInforMapper;
import com.ywb.springbootwebdao.io.model.UserInfor;
import com.ywb.springbootwebutils.io.utils.ReadExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ReadExcelService {

    private static final Logger log = LoggerFactory.getLogger(ReadExcelService.class);

    @Autowired
    private UserInforMapper userInforMapper;


    public void readExcel(){

        log.info("readExcelService is beginning ... ");

        ReadExcelUtil readExcel = new ReadExcelUtil();
        List<Object[]> datas = readExcel.readExcel();
        UserInfor userInfor = null;
        Map<String, Object> map = new HashMap<String, Object>();
        //特殊处理，将读取的数据插入 user_infor　表
        for (int i = 0; i < datas.size(); i++) {
            Object[] objects = datas.get(i);
            userInfor.setUserName(objects[1].toString());
            userInfor.setIdNumber(objects[2].toString());
            userInfor.setMobile(objects[3].toString());
            userInfor.setBankCardNumber(objects[4].toString());
            if (objects[2].toString().length() == 15) {
                map = getCardInfo2(objects[2].toString());
                userInfor.setSex(map.get("sex").toString());
                userInfor.setIsAdult(Integer.parseInt(map.get("age").toString()) < 18 ? "否" : "是");
            } else {
                map = getCardInfo(objects[2].toString());
                userInfor.setSex(map.get("sex").toString());
                userInfor.setIsAdult(Integer.parseInt(map.get("age").toString()) < 18 ? "否" : "是");
            }
            userInforMapper.insert(userInfor);
        }
        log.info("readExcelService is over ...");

    }

    //根据身份证号判断性别 及 年龄
    //据身份证的号码算出当前身份证持有者的性别和年龄 18位身份证号
    private Map<String, Object> getCardInfo(String idNumber) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String year = idNumber.substring(6).substring(0, 4);//获取年份
        String month = idNumber.substring(6).substring(4, 6);//获取月份
        String day = idNumber.substring(6).substring(6, 8);//获取天

        String sex = null;
        if (Integer.parseInt(idNumber.substring(16).substring(0, 1)) % 2 == 0) {
            sex = "女";
        } else {
            sex = "男";
        }
        map.put("sex", sex);
        int age = 0;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
        String sysYear = sdf.format(date).substring(0, 4);//系统年份
        String sysMonth = sdf.format(date).substring(4, 6);//系统月份
        if (Integer.parseInt(month) <= Integer.parseInt(sysMonth)) {
            age = Integer.parseInt(sysYear) - Integer.parseInt(year) + 1;
        } else
            age = Integer.parseInt(sysYear) - Integer.parseInt(year);
        map.put("age", age);
        return map;
    }

    //根据身份证号判断性别 及 年龄
    //据身份证的号码算出当前身份证持有者的性别和年龄 15位身份证号
    private Map<String, Object> getCardInfo2(String idNumber) {
        HashMap<String, Object> map = new HashMap<>();
        String year = idNumber.substring(6, 8);
        String month = idNumber.substring(8, 10);
        String sex = null;
        if (Integer.parseInt(idNumber.substring(14, 15).toString()) % 2 == 0) {
            sex = "女";
        } else {
            sex = "男";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
        String sysYear = sdf.format(date).substring(0, 4);
        String sysMonth = sdf.format(date).substring(4, 6);
        int age = 0;
        if (Integer.parseInt(sysMonth) > Integer.parseInt(month)) {
            age = Integer.parseInt(sysYear) - Integer.parseInt(year) + 1;
        } else {
            age = Integer.parseInt(sysYear) - Integer.parseInt(year);
        }
        map.put("age", age);
        map.put("sex", sex);
        return map;
    }


}
