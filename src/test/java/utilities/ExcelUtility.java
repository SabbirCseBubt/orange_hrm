package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {
 
	
	
	
    public static Object[][] getExcelData(String path, String sheetName)
            throws Exception {

        FileInputStream fis = new FileInputStream(path);

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheet(sheetName);

        if(sheet == null)
        {
            throw new RuntimeException(
                    "Sheet not found: " + sheetName);
        }

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < cols; j++) {

                Cell cell = sheet.getRow(i).getCell(j);

                data[i - 1][j] =
                        (cell == null) ? "" : cell.toString();
            }
        }

        wb.close();
        fis.close();

        return data;
    }
}