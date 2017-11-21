package edu.zust.survey.util;

import edu.zust.survey.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

    private static Map<String, Integer> majorMap = new HashMap<String, Integer>();

    public static List<Student> importExcel2List(InputStream inputStream, String fileName) throws IOException {
        init();
        Workbook workbook;
        if (fileName.endsWith(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileName.endsWith(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        } else {
            return null;
        }
        Student student = null;
        List<Student> list = new ArrayList<Student>();
        // 循环工作表Sheet
        Cell username = null;
        Cell password = null;
        Cell name = null;
        Cell major = null;
        Cell klasse = null;
        String klasseString = null;
        String gradeString = null;
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            Sheet sheet = workbook.getSheetAt(numSheet);
            if (sheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row != null) {
                    student = new Student();
                    username = row.getCell(0);
                    password = row.getCell(1);
                    name = row.getCell(2);
                    major = row.getCell(4);
                    klasse = row.getCell(5);
                    student.setUsername(username.getStringCellValue());
                    student.setPassword(password.getStringCellValue());
                    student.setName(name.getStringCellValue());
                    student.setKlasse(klasse.getStringCellValue());
                    student.setMajorId(majorMap.get(major.getStringCellValue()));
                    klasseString = klasse.getStringCellValue();
                    //System.out.println(klasseString.length() + " " +major.getStringCellValue().length());
                    gradeString = klasseString.substring(klasseString.length() - 3, klasseString.length() - 1);
                    student.setGrade(2000 + Integer.valueOf(gradeString));
                    list.add(student);
                }
            }
        }
        inputStream.close();
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

}
