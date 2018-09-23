package com.ywb.springbootwebutils.io.utils;

import com.ywb.springbootwebdao.io.dao.UserInforMapper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
@Service
public class ReadExcelUtil {

    private static final Logger log = LoggerFactory.getLogger(ReadExcelUtil.class);

    @Value("${com.ywb.io.readurl}")
    private String filePath;

    @Autowired
    private UserInforMapper userInforMapper;


    public List<Object[]> readExcel() {

        log.info("readExcel is beginning !");
        //判断 EXCEL 版本
        boolean isExcel2003 = filePath.toLowerCase().endsWith("xls") ? true : false;
        //工作区间
        int sheetNum = 0;
        //存储读取 EXCLE 的数据
        ArrayList<Object[]> datas = new ArrayList<>();
        if (isExcel2003) {
            try {
                datas = readXLS(filePath, sheetNum);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } else {
            try {
                datas = readXLSX(filePath, sheetNum);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        log.info(datas.toString());
        return datas;
    }


    //读取 .xlsx 格式的 EXCEL
    private ArrayList<Object[]> readXLSX(String filePath, int sheetNum) throws IOException {
        log.info("readXLSX is begginning ! ");
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        ArrayList<Object[]> datas = new ArrayList<>();

        /*step1：获取 EXCEL 的工作区间总数*/
        log.info("step1 : get the total number of EXCEL workspaces xlsx .");
        int sheetNo = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetNo; i++) {
            if (i != sheetNum) {
                continue;
            }
            /*step2：取得所需工作区间（下标从 0 开始）*/
            log.info("step2 : get the required working range (subscript starts from 0) xlsx .");
            XSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                return datas;
            }
            /*step3：获取总共有多少行数据因为中间空行而读取出来的数据不准确*/
            log.info("step3 : get the total number of rows,because the data read out in the middle empty line is not accurate （xlsx） .");
            int hasRowNum = sheet.getPhysicalNumberOfRows();
            if (hasRowNum == 0) {
                return datas;
            }
            int processedNum = 0;
            for (int j = 0; ; j++) {
                /*step4：获取每一行*/
                log.info("step4 : get every row (xlsx).");
                XSSFRow row = sheet.getRow(j);
                /*step5：去除空行*/
                log.info("step5 : remove the empth line （xlsx） .");
                if (row != null) {
                    /*step6：获取每一行的长度*/
                    log.info("step6 : get the length of each row（xlsx） .");
                    short length = row.getLastCellNum();
                    if (length > 0) {
                        Object[] data = new Object[length];
                        for (short m = 0; m < length; m++) {
                            /*step7：获取每行的每一列的值*/
                            log.info("step7 : get the value of each row of each row (xlsx).");
                            if (m < 2) {
                                continue;
                            }
                            data[m] = row.getCell(m);
                        }
                        /*step8：存数据*/
                        log.info("step8 : storage data (xlsx).");
                    }
                    processedNum++;
                    //当处理完所有的数据，终止循环
                    if (processedNum == hasRowNum) {
                        break;
                    }
                }
            }
        }
        inputStream.close();
        return datas;
    }

    //读取以 XLS 结尾的 EXCEL
    private ArrayList<Object[]> readXLS(String filePath, int sheetNum) throws IOException {

        log.info("readXLS is begginning ! ");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        ArrayList<Object[]> datas = new ArrayList<>();//用于存储数据

        /*step1：获取 EXCEL 的工作区间总数*/
        log.info("step1 : get the total number of EXCEL workspaces .");
        int sheetNo = workbook.getNumberOfSheets();//取得工作区间个数

        for (int i = 0; i < sheetNo; i++) {

            if (i != sheetNum) {
                continue;
            }

            /*step2：取得所需工作区间（下标从 0 开始）*/
            log.info("step2 : get the required working range (subscript starts from 0 .");
            HSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                return datas;
            }

            /*step3：获取总共有多少行数据因为中间空行而读取出来的数据不准确*/
            log.info("step3 : get the total number of rows,because the data read out in the middle empty line is not accurate .");
            int hasRowNum = sheet.getPhysicalNumberOfRows();
            if (hasRowNum == 0) {
                return datas;
            }

            //已经处理了的行数
            int processedNum = 0;
            for (int j = 0; ; j++) {

                /*step4：获取每一行*/
                log.info("step4 : get every row .");
                HSSFRow row = sheet.getRow(j);

                /*step5：去除空行*/
                log.info("step5 : remove the empth line .");
                if (row != null) {

                    /*step6：获取每一行的长度*/
                    log.info("step6 : get the length of each row .");
                    int length = row.getLastCellNum();
                    if (length > 0) {
                        //定义一个集合，装每行的数值
                        Object[] data = new Object[length];
                        for (short m = 0; m < length; m++) {
                            if (m < 2) {
                                continue;
                            }
                            /*step7：获取每行的每一列的值*/
                            log.info("step7 : get the value of each row of each row .");
                            data[m] = row.getCell(m);
                        }
                        /*step8：存数据*/
                        log.info("step8 : storage data .");
                        datas.add(data);
                    }
                    processedNum++;
                    //当处理完所有的数据，终止循环
                    if (processedNum == hasRowNum) {
                        break;
                    }
                }
            }
        }
        fileInputStream.close();
        return datas;
    }

}
