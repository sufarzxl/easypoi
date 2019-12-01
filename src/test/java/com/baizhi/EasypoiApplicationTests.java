package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class EasypoiApplicationTests {

    @Test
    public void contextLoads() {
        List<Teacher> teas=new ArrayList<>();
        List<Student> stus=new ArrayList<>();
        Student s1 = new Student("s1", "学生A", "true", "001", "一年级");
        Student s2 = new Student("s2", "学生B", "false", "002", "二年级");
        Student s3 = new Student("s3", "学生C", "true", "003", "三年级");
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        Teacher t1 = new Teacher("1", "老师A", "false", 9988.88, new Date(),stus);
        Teacher t2 = new Teacher("2", "老师B", "true", 19988.88, new Date(),stus);
        Teacher t3 = new Teacher("3", "老师C", "false", 29988.88, new Date(),stus);
        teas.add(t1);
        teas.add(t2);
        teas.add(t3);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("老师名单","老师"),
                Teacher .class, teas);
        try {
            workbook.write(new FileOutputStream(new File("D:/c.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws Exception {
        //导入参数
        ImportParams importParams = new ImportParams();
        //表格标题行数,默认0
        importParams.setTitleRows(1);
        //表头行数
        importParams.setHeadRows(2);
        //方法来自官网，简单修改即可使用
        List<Teacher> list = ExcelImportUtil.importExcel(
                new FileInputStream(new File("D:/c.xls")),Teacher.class,importParams);
        for (Teacher teacher : list) {
            System.out.println("teacher = " + teacher);
        }
    }

    @Test
    public void test2() {
        System.out.println(new Date());
    }
}
