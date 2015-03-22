package com.imipgroup.hieuvt.xls;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hieu.vutrong on 3/22/2015.
 */
public class ExelUtils {
    public List<Row> readFromExel(String path){
        List<Row> rows = new ArrayList<Row>();
        try {
            FileInputStream file = new FileInputStream(new File(path));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()){
                rows.add(rowIterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public String createNewExel(String fileName, List<List<String>> data){
        String filePath = "files/Exel/" + fileName +".xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sample Sheet");
        int rowNum = 0;
        for(List<String> rowData: data){
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for(String cellData: rowData){
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(cellData);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(filePath)); //in struts, write to output stream
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
