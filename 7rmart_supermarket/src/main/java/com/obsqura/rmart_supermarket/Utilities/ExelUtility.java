package com.obsqura.rmart_supermarket.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.obsqura.rmart_supermarket.constant.Constant;

public class ExelUtility {
	static FileInputStream fi;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String readName(int a, int b, String sheet) throws IOException {
		fi = new FileInputStream(Constant.EXELPATH);
		w = new XSSFWorkbook(fi);
		s = w.getSheet(sheet);
		XSSFRow row = s.getRow(a);
		XSSFCell cell = row.getCell(b);
		return cell.getStringCellValue();

	}

	public static String getId(int a, int b, String sheet) throws IOException {
		fi = new FileInputStream(Constant.EXELPATH);
		w = new XSSFWorkbook(fi);
		s = w.getSheet(sheet);
		XSSFRow row = s.getRow(a);
		XSSFCell cell = row.getCell(b);
		int y = (int) cell.getNumericCellValue();// type casting

		return String.valueOf(y);

	}

}
