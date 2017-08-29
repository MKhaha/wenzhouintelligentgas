package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by lanmeiniu on 2017/8/23.
 */

public class ImportExcel {
    private Workbook wb = null;
    private Sheet sheet = null;
    private Row row = null;
    private int sheetNum = 0;
    private int rowNum = 0;
    private FileInputStream fis = null;
    private File file = null;
    private DecimalFormat df = new DecimalFormat("0");
    public ImportExcel() {
        super();
    }
    public void setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
    }
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
    public void setFile(File file) {
        this.file = file;
    }
    /**
     * 读取excel文件获得HSSFWorkbook对象
     * @throws IOException
     */
    public void open(String filePath) throws IOException {
        //验证文件是否存在
        if(validateExcel(filePath)) {
            file = new File(filePath);
            fis = new FileInputStream(file);
            if(isExcel2003(filePath)) {
                wb = new HSSFWorkbook(fis);
            } else {
                wb = new XSSFWorkbook(fis);
            }
            fis.close();
        }
    }

    /**
     * 获取sheet表数目
     * @return sheet表数目
     */
    public int getSheetCount() {
        int sheetCount = -1;
        sheetCount = wb.getNumberOfSheets();
        return sheetCount;
    }

    /**
     * 获取sheetNum下的记录行数
     * @return 记录行数
     */
    public int getRowCount() {
        if(wb == null) {
            System.err.println("----------->WorkBook为空");
        }
        Sheet sheet = wb.getSheetAt(this.sheetNum);
        int rowCount = -1;
        rowCount = sheet.getLastRowNum();
        if(rowCount > 1000) {
            rowCount = 1000;
        }
        return rowCount;
    }

    /**
     * 获取指定sheetNum的记录行数
     * @param sheetNum 表编号
     * @return 记录行数
     */
    public int getRowCount(int sheetNum) {
        Sheet sheet = wb.getSheetAt(sheetNum);
        int rowCount = -1;
        rowCount = sheet.getLastRowNum();
        return rowCount;
    }

    /**
     * 得到指定行的内容
     * @param lineNum 行数
     * @return 内容
     */
    public String[] readExcelLine(int lineNum) {
        return readExcelLine(this.sheetNum, lineNum);
    }

    /**
     * 获取指定工作表和行数的内容
     * @param sheetNum 表编号
     * @param lineNum 行数
     * @return 内容
     */
    public String[] readExcelLine(int sheetNum, int lineNum) {
        if(sheetNum < 0 || lineNum < 0) {
            return null;
        }
        String[] strExcelLine = null;
        try {
            sheet = wb.getSheetAt(sheetNum);
            row = sheet.getRow(lineNum);

            int cellCount = row.getLastCellNum();
            strExcelLine = new String[cellCount + 1];
            for(int i = 0; i <= cellCount; i++) {
                //readStringExcelCell 获取指定行和列编号的内容
                strExcelLine[i] = readStringExcelCell(lineNum, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strExcelLine;
    }

    /**
     * 获取指定列的内容
     * @param cellNum 列编号
     * @return 内容
     */
    public String readStringExcelCell(int cellNum) {
        return readStringExcelCell(this.rowNum, cellNum);
    }

    /**
     * 获取指定行和列编号的内容
     * @param rowNum 行编号
     * @param cellNum 列编号
     * @return 内容
     */
    public String readStringExcelCell(int rowNum, int cellNum) {
        return readStringExcelCell(this.sheetNum, rowNum, cellNum);
    }

    /**
     * 获取指定工作表、行、列的内容
     * @param sheetNum 表编号
     * @param rowNum 行编号
     * @param cellNum 列编号
     * @return 内容
     */
    public String readStringExcelCell(int sheetNum, int rowNum, int cellNum) {
        if(sheetNum < 0 || rowNum < 0) {
            return "";
        }
        String strExcelCell = "";
        try {
            sheet = wb.getSheetAt(sheetNum);
            row = sheet.getRow(rowNum);

            if(row.getCell(cellNum) != null) {
                switch(row.getCell(cellNum).getCellType()) {
                    case HSSFCell.CELL_TYPE_FORMULA:
                        strExcelCell = "FORMULA";
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        //strExcelCell = String.valueOf(row.getCell(cellNum).getNumericCellValue());
                        //防止科学计数，不需要的话可以用上一行
                        strExcelCell = decimalFormat(row.getCell(cellNum).getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_STRING:
                        strExcelCell = row.getCell(cellNum).getStringCellValue();
                        break;
                    case HSSFCell.CELL_TYPE_BLANK:
                        strExcelCell = "";
                        break;
                    default:
                        strExcelCell = "";
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strExcelCell;
    }
    /**
     * 验证文件是否存在以及是否是excel文件
     * @param filePath
     * @return 结果
     */
    public boolean validateExcel(String filePath) {
        if(filePath == null || ! (isExcel2003(filePath) || isExcel2007(filePath))) {
            System.err.println("文件不是excel文件！");
            return false;
        }
        File file = new File(filePath);
        if(file == null || ! file.exists()) {
            System.err.println("文件不存在！");
            return false;
        }
        return true;
    }

    /**
     * 判断是否是2003版excel
     * @param filePath 文件路径
     * @return 结果
     */
    public boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 判断是否是2007版excel
     * @param filePath 文件路径
     * @return 结果
     */
    public boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 将获取到的数据类型转换成String防止科学计数法
     * @param decimal 数据
     * @return 结果
     */
    public String decimalFormat(Double decimal) {
        return df.format(decimal);
    }
}

