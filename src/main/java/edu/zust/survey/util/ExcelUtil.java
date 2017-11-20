package edu.zust.survey.util;

import edu.zust.survey.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2017/11/20.
 */
public class ExcelUtil {

    private ExcelUtil(){}

    public static List<Student> importExcel2DB(InputStream inputStream) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        Student student = null;
        List<Student> list = new ArrayList<Student>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    student = new Student();
                    HSSFCell username = hssfRow.getCell(0);
                    HSSFCell password = hssfRow.getCell(1);
                    HSSFCell name = hssfRow.getCell(2);
                    HSSFCell major = hssfRow.getCell(4);
                    HSSFCell klasse = hssfRow.getCell(5);

                    list.add(student);
                }
            }
        }
        return list;
    }
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
