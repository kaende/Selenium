import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelSuma {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\DELL\\Desktop\\Brojevi.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("Brojevi");
        XSSFRow row = sh.getRow(0);
        XSSFCell cell = row.getCell(0);

        double sum = 0;

        for (int i = 0; i <= wb.getSheet("Brojevi").getLastRowNum(); i++) {
            sum+=sh.getRow(i).getCell(0).getNumericCellValue();
        }

        System.out.println(sum);

    }
}
