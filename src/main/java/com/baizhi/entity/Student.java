package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Student {
    @Excel(name="编号")
    private String id;
    @Excel(name="姓名")
    private String name;
    @Excel(name="性别",replace={"男_true","女_false"},suffix="生")
    private String sex;
    @Excel(name="学号")
    private String num;
    @Excel(name="年级")
    private String grade;
}
