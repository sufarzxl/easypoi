package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
@ExcelTarget("各位老师")
public class Teacher {
    @ExcelIgnore
    private String id;
    @Excel(name="姓名",needMerge=true)
    private String name;
    @Excel(name="性别",replace={"男_true","女_false"},needMerge=true)
    private String sex;
    @Excel(name="工资",needMerge=true)
    private Double salary;
    @Excel(name="生日",format = "yyyy-MM-dd",needMerge=true)
    private Date bir;
    @ExcelCollection(name="各位同学")
    private List<Student> students;
}
