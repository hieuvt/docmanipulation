package com.imipgroup.hieuvt.pdf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PdfUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

//    @Test
//    public void testCreatePdf() throws Exception {
//        PdfUtils pdfUtils = new PdfUtils();
//        pdfUtils.createPdf("testCreate");
//    }

    @Test
    public void testReadPdf() throws Exception {
        PdfUtils pdfUtils = new PdfUtils();
        pdfUtils.createPdf("testCreate");
        pdfUtils.readPdf("files/Pdf/testCreate.pdf");
    }
}