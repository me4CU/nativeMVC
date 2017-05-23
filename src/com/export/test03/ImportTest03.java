package com.export.test03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.export.util.ExcelUtil;


public class ImportTest03 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("m:\\success3.xls");
			ExcelUtil<StudentVO> util = new ExcelUtil<StudentVO>(
					StudentVO.class);// 创建excel工具类
			System.out.println("Import test03 -------------Start！");
			List<StudentVO> list = util.importExcel("学生信息0112", fis);// 导入
			System.out.println(list);
			System.out.println("Import test03 -------------End");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
