package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guotao on 2017/8/28.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.util
 * wenzhouintelligentgas
 */
public class GetTableFieldComment {

    private static String urlMysql = "jdbc:mysql://localhost:3306/";
    private static String dataBaseName = "wen_zhou_intelligent_gas";
    private static String username = "root";
    private static String passwordMysql = "MKhaha_05050909";
    private static Map<String, Map<String, String>> tableFiledComments = null;

    public static Map<String, Map<String, String>> getTableFieldComments() throws SQLException, ClassNotFoundException {
        if (tableFiledComments == null) {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            tableFiledComments = new HashMap<>();
            List<String> tableNames = getTableName();
            return getFieldComments(tableNames);
        } else {
            return tableFiledComments;
        }
    }

    private static Map<String, Map<String, String>> getFieldComments(List<String> tableNames) throws SQLException{

        String url = urlMysql + "information_schema";    //JDBC的URL
        Connection conn;

        conn = DriverManager.getConnection(url,    username,passwordMysql);
        Statement stmt = conn.createStatement(); //创建Statement对象
        System.out.println("成功连接到数据库！");

        for (String tableName : tableNames) {

            Map<String, String> filedComments = new HashMap<>();

            String sql = String.format("select COLUMN_NAME,column_comment from INFORMATION_SCHEMA.Columns where table_name='%s' and table_schema='%s'", tableName, dataBaseName);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("tableName = [" + tableName + "]");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                filedComments.put(rs.getString(1), rs.getString(2));
            }
            System.out.println("+++++++++++++++++++++++++++++");
            rs.close();

            tableFiledComments.put(tableName, filedComments);

        }

        stmt.close();
        conn.close();

        System.out.println(tableFiledComments.toString());
        return tableFiledComments;

    }

    private static List<String> getTableName() throws SQLException{

        List<String> tableNames = new ArrayList<>();

        String url = urlMysql + dataBaseName;    //JDBC的URL
        Connection conn;

        conn = DriverManager.getConnection(url,username,passwordMysql);
        Statement stmt = conn.createStatement(); //创建Statement对象
        System.out.println("成功连接到数据库！");

        String sql = "show tables";    //要执行的SQL
        ResultSet rs = stmt.executeQuery(sql);//创建数据对象
        System.out.println("数据库名");
        while (rs.next()){
            System.out.print(rs.getString(1));
            tableNames.add(rs.getString(1));

            System.out.println();

        }
        rs.close();
        stmt.close();
        conn.close();

        return tableNames;
    }

    public static void main(String[] args){
        try {
            getTableFieldComments();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
