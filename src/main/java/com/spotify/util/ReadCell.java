package com.spotify.util;

import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public final class ReadCell {
	public static String read(Sheet sheet, int i, int j) {
		Cell cell = sheet.getRow(i).getCell(j);
		String value = null;
		try {
			value = String.valueOf(BigDecimal.valueOf(cell.getNumericCellValue())); 
		} catch (Exception e1) {
			try {
				value = cell.getStringCellValue(); 
			} catch (Exception e2) {
				try {
					value = String.valueOf(cell.getBooleanCellValue()); 
				} catch (Exception exception) {

				}
			}
		}
		return value;
	}
}
