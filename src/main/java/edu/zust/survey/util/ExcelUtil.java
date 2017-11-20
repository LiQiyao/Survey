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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lee on 2017/11/20.
 */
public class ExcelUtil {

    private ExcelUtil(){}

    private static Map<String, Integer> majorMap = new HashMap<>();

    public static List<Student> importExcel2DB(InputStream inputStream) throws IOException {
        init();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        Student student = null;
        List<Student> list = new ArrayList<Student>();
        // 循环工作表Sheet
        HSSFCell username = null;
        HSSFCell password = null;
        HSSFCell name = null;
        HSSFCell major = null;
        HSSFCell klasse = null;
        String klasseString = null;
        String gradeString = null;
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
                    username = hssfRow.getCell(0);
                    password = hssfRow.getCell(1);
                    name = hssfRow.getCell(2);
                    major = hssfRow.getCell(4);
                    klasse = hssfRow.getCell(5);
                    student.setUsername(username.getStringCellValue());
                    student.setPassword(password.getStringCellValue());
                    student.setName(name.getStringCellValue());
                    student.setKlasse(klasse.getStringCellValue());
                    student.setMajorId(majorMap.get(major.getStringCellValue()));
                    klasseString = klasse.getStringCellValue();
                    gradeString = klasseString.substring(major.getStringCellValue().length(), major.getStringCellValue().length());

                    student.setGrade(Integer.valueOf(gradeString));
                    list.add(student);
                }
            }
        }
        return list;
    }

    private static void init(){
        majorMap.put("软件工程", 1);
        majorMap.put("计算机科学与技术", 2);
        majorMap.put("数字媒体技术", 3);
        majorMap.put("电子信息工程", 4);
        majorMap.put("物联网工程", 5);
        majorMap.put("通信工程", 6);

    }

    private static String getValue(HSSFCell hssfCell) {
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
