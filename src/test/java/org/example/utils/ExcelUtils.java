package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getTestData() throws Exception {

        FileInputStream file = new FileInputStream("src/test/resources/testData.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum();

        DataFormatter formatter = new DataFormatter();

        List<Object[]> dataList = new ArrayList<>();

        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);

            // ✅ skip null rows
            if (row == null) continue;

            String username = formatter.formatCellValue(row.getCell(0));
            String password = formatter.formatCellValue(row.getCell(1));
            String type = formatter.formatCellValue(row.getCell(2));
            String value = formatter.formatCellValue(row.getCell(3));

            // ✅ skip empty rows
            if (username.isEmpty() && password.isEmpty() && type.isEmpty()) {
                continue;
            }

            dataList.add(new Object[]{username, password, type, value});
        }

        workbook.close();
        file.close();

        // Convert List → Object[][]
        Object[][] data = new Object[dataList.size()][4];

        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }
}