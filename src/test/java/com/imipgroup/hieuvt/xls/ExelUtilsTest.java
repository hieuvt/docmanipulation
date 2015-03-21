package com.imipgroup.hieuvt.xls;

import com.imipgroup.hieuvt.xls.xls.ExelUtils;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExelUtilsTest {

    ExelUtils exelUtils;
    String inputFile;

    @org.junit.Before
    public void setUp() throws Exception {
        exelUtils = new ExelUtils();
        inputFile = "files/Exel/testread.xlsx";
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testReadFromExel() throws Exception {
        List<Row> rows = exelUtils.readFromExel(inputFile);
        assertTrue(rows.get(1).getCell(0).getNumericCellValue() == 1);
    }

    @Test
    public void testCreateNewExel() throws Exception {
        List<String> row1 = new ArrayList<String>();
        row1.add("col11");
        row1.add("col12");
        List<String> row2 = new ArrayList<String>();
        row1.add("col21");
        row1.add("col22");
        List<List<String>> rows = new ArrayList<List<String>>();
        rows.add(row1);
        rows.add(row2);
        String filePath = exelUtils.createNewExel("testwrite", rows);
        List<Row> xlsRows = exelUtils.readFromExel(filePath);
        assertTrue(xlsRows.get(0).getCell(0).getStringCellValue().equals("col11"));
    }
}