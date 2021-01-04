package com.spotify.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class GetRecords {

	public static ArrayList<HashMap<String, String>> read(String filepath) {
		ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
			Sheet sheet = workbook.getSheetAt(0);
			String key = null;
			String value = null;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				for (int j = 0; j <= sheet.getRow(i).getLastCellNum(); j++) {
					key = ReadCell.read(sheet, 0, j);
					value = ReadCell.read(sheet, i, j);
					map.put(key, value);
				}
				data.add(map);
			}
			workbook.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return data;
	}
}
