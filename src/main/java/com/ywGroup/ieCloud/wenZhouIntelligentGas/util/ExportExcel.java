package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExportExcel {
    //默认列宽度
    private final int DEFAULT_COLUMN_SIZE = 30;
    //刷新写入硬盘数据阀值
    private final int flushRows = 1000;
    //声明一个模板工作薄(写入流式数据)
    private Workbook writeDataWorkBook;

    //Excel当前数据行数(将要写入数据的索引数)
    private int currentRowNum = 0;
    //数据输出流
    private OutputStream outputStream;

    /**
     *
     * @param session    HttpSession获取路径
     * @param sheetName  工作簿名
     * @param sheetTitle 工作簿首行标题
     * @param tableName  数据库的表名
     * @param list<T>    需要导出的数据
     * @return
     * @throws Exception
     */
    public static <T> String toExcel(HttpSession session, String sheetName, String sheetTitle, String tableName,List<T> list) {
        //获取路径名
        String filePath = session.getServletContext().getRealPath("/upload/");
        //随机生成文件名
        String fileName = UUID.randomUUID().toString().replace("-", "") + ".xlsx";
        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File file = new File(filePath, fileName);
        try {
            file.createNewFile();

            //通过实例化类获取属性，new,获得实体类的所有属性
            Map<String, Map<String, String>> comments = GetTableFieldComment.getTableFieldComments();
            Map<String, String> AdminsComments = comments.get(tableName);

            //创建列名的英文名和中文名
            List<String> columnNames = new LinkedList<>();
            List<String> valesName = new LinkedList<>();
            Field[] fields = list.get(0).getClass().getDeclaredFields();
            //简单的for循环 遍历所有属性
            for (int i = 0; i < fields.length; i++) {
                columnNames.add(AdminsComments.get(fields[i].getName()));
                valesName.add(fields[i].getName());
            }
            List<List<Object>> l = new ArrayList<>();
            for (T t1 : list) {
                List<Object> objects = new ArrayList<>();
                for (int i = 0; i < valesName.size(); i++) {
                    objects.add(ReflectionUtils.getFieldValue(t1, valesName.get(i)));
                }
                l.add(objects);
            }
            ExportExcel exportExcel2007 = new ExportExcel();
            exportExcel2007.writeExcelTitle(file, sheetName, columnNames, sheetTitle);
            exportExcel2007.writeExcelData(file, sheetName, l);
            exportExcel2007.dispose();
        }
        catch (Exception e){
            file.delete();
            return null;
        }
        return "/upload/"+fileName;
    }

    /**
     * 日期转化为字符串,格式为yyyy-MM-dd HH:mm:ss
     */
    private String getCnDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    /**
     * Excel 导出，POI实现，先写入Excel标题，与writeExcelData配合使用
     * 先使用writeExcelTitle再使用writeExcelData
     * @param sheetName   sheetName
     * @param columnNames 列名集合
     * @param sheetTitle  表格标题
     */
    public File writeExcelTitle(File tmpFile,String sheetName, List<String> columnNames,String sheetTitle) throws IOException {
        exportExcelTitle(tmpFile, sheetName, columnNames, sheetTitle);
        //加载临时excel模板
        loadTplWorkbook(tmpFile);
        return tmpFile;
    }
    /**
     * Excel 导出，POI实现，写入Excel数据行列，与writeExcelTitle配合使用
     * 先使用writeExcelTitle再使用writeExcelData
     *
     * @param sheetName sheetName
     * @param objects   数据信息
     */
    public File writeExcelData(File tmpFile,String sheetName, List<List<Object>> objects)
            throws IOException {
        outputStream = new FileOutputStream(tmpFile);
        //导出字符串数据
        exportExcelData(sheetName, objects);
        return tmpFile;
    }
    /**
     * 释放资源
     */
    public void dispose() throws IOException {
        try {
            if (writeDataWorkBook != null) {
                writeDataWorkBook.write(outputStream);
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
            outputStream = null;
            writeDataWorkBook = null;
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    /**
     * 导出字符串数据标题
     * @param file        文件名
     * @param columnNames 表头
     * @param sheetTitle  sheet页Title
     */
    private void exportExcelTitle(File file, String sheetName, List<String> columnNames, String sheetTitle) throws IOException {
        //申明Excel2007的版本的工作簿
        Workbook tplWorkBook = new XSSFWorkbook();

        // 生成一个表格，并且命名为用户自定义的名称
        Sheet sheet = tplWorkBook.getSheet(sheetName);
        if (sheet == null) {
            sheet = tplWorkBook.createSheet(sheetName);
        }
        //最新Excel列索引,从0开始
        //int lastRowIndex = sheet.getLastRowNum();
        // 设置表格默认列宽度
        sheet.setDefaultColumnWidth(DEFAULT_COLUMN_SIZE);
        // 合并单元格，根据列名的长度来决定合并单元格的格子数
        sheet.addMergedRegion(new CellRangeAddress(currentRowNum, currentRowNum, 0, columnNames.size() - 1));
        // 产生表格标题行
        Row rowMerged = sheet.createRow(currentRowNum);
        Cell mergedCell = rowMerged.createCell(0);
        mergedCell.setCellValue(new XSSFRichTextString(sheetTitle));
        //写入成功一行数据递增行数
        currentRowNum = currentRowNum + 1;
        // 产生表格表头列标题行
        Row row = sheet.createRow(currentRowNum);
        for (int i = 0; i < columnNames.size(); i++) {
            Cell cell = row.createCell(i);
            RichTextString text = new XSSFRichTextString(columnNames.get(i));
            cell.setCellValue(text);
        }
        //写入成功一行数据递增行数
        currentRowNum = currentRowNum + 1;
        try {
            OutputStream ops = new FileOutputStream(file);
            tplWorkBook.write(ops);
            ops.flush();
            ops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载模板文件
     */
    private void loadTplWorkbook(File file) throws IOException {
        try {
            // FileInputStream可以从文件系统中的某个文件中获得输入字节
            XSSFWorkbook tplWorkBook = new XSSFWorkbook(new FileInputStream(file));
            //根据初始化设置的flushRows(内存存储条数)数随着数据写入逐步把数据刷新至硬盘
            writeDataWorkBook = new SXSSFWorkbook(tplWorkBook, flushRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出字符串数据
     *
     * @param objects 目标数据
     */
    private void exportExcelData(String sheetName, List<List<Object>> objects) throws IOException {

        // 生成一个表格
        Sheet sheet = writeDataWorkBook.getSheet(sheetName);

        if (sheet != null) {
            // 设置表格默认列宽度
            sheet.setDefaultColumnWidth(DEFAULT_COLUMN_SIZE);
            // 遍历集合数据,产生数据行,前两行为标题行与表头行
            for (List<Object> dataRow : objects) {
                Row row = sheet.createRow(currentRowNum);
                for (int j = 0; j < dataRow.size(); j++) {
                    Cell contentCell = row.createCell(j);
                    Object dataObject = dataRow.get(j);
                    if (dataObject != null) {
                        //instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例
                        if (dataObject instanceof Integer) {
                            contentCell.setCellValue(Integer.parseInt(dataObject.toString()));
                        } else if (dataObject instanceof Double) {
                            contentCell.setCellValue(Double.parseDouble(dataObject.toString()));
                        } else if (dataObject instanceof Long && dataObject.toString().length() == 13) {
                            contentCell.setCellValue(getCnDate(new Date(Long.parseLong(dataObject.toString()))));
                        } else if (dataObject instanceof Date) {
                            contentCell.setCellValue(getCnDate((Date) dataObject));
                        } else {
                            contentCell.setCellValue(dataObject.toString());
                        }
                    } else {
                        // 设置单元格内容为字符型
                        contentCell.setCellValue("");
                    }
                }
                //写入成功一行数据递增行数
                currentRowNum = currentRowNum + 1;
            }
            try {
                ((SXSSFSheet) sheet).flushRows(flushRows);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

