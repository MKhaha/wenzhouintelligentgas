package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
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

    private static String urlMysql = "jdbc:mysql://192.168.1.107:3306/";
    private static String dataBaseName = "wen_zhou_intelligent_gas";
    private static String username = "root";
    private static String passwordMysql = "MKhaha_05050909";

    private static String tableFieldCommentTableName = "table_field_comment";
    private static String tableFieldCommentTableField1 = "table_name";
    private static String tableFieldCommentTableField2 = "field_comment";
    private static Map<String, Map<String, String>> tableFiledComments = new HashMap<>();

    public static final char UNDERLINE='_';

    public static Map<String, Map<String, String>> getTableFieldComments() throws SQLException, ClassNotFoundException, IOException {
        if (tableFiledComments.isEmpty()) {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("成功加载MySQL驱动！");

            tableFiledComments = new HashMap<>();
            List<String> tableNames = getTableName();
            return getFieldComments(tableNames);
        } else {
            return tableFiledComments;
        }
    }


    private static void insertFieldComments(Map<String, Map<String, String>> tableFiledComments) throws SQLException{

        String url = urlMysql + dataBaseName;    //JDBC的URL
        Connection conn;

        conn = DriverManager.getConnection(url,username,passwordMysql);
        //System.out.println("成功连接到数据库！");

        PreparedStatement pstmt;
        for (Map.Entry<String, Map<String, String>> fieldComments : tableFiledComments.entrySet()) {

            Gson gson = new Gson();
            String jsonComments = gson.toJson(fieldComments.getValue());
            //System.out.println("jsonComments.length = [" + jsonComments.length() + "]");
            //System.out.println("table_name.length = [" + fieldComments.getKey().length() + "]");

            String sql = String.format("INSERT INTO %s (table_name, field_comment) VALUES(?, ?); ",
                    tableFieldCommentTableName,
                    tableFieldCommentTableField1,
                    tableFieldCommentTableField2);

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, fieldComments.getKey());
            pstmt.setString(2, jsonComments);
            pstmt.executeUpdate();
            pstmt.close();
        }

        conn.close();

        //System.out.println(tableFiledComments.toString());
        return;
    }

    public static String underlineToCamel(String param){

        if (StringUtils.isBlank(param)){
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (c==UNDERLINE){
                if (++i<len){
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static Map<String, Map<String, String>> getFieldComments(List<String> tableNames) throws SQLException, IOException{

        String url = urlMysql + "information_schema";    //JDBC的URL
        Connection conn;
        conn = DriverManager.getConnection(url,username,passwordMysql);
        Statement stmt = conn.createStatement(); //创建Statement对象
        //System.out.println("成功连接到数据库！");
        for (String tableName : tableNames) {
            if (tableName.startsWith("act_")) {
                continue;
            }
            Map<String, String> filedComments = new HashMap<>();
            String sql = String.format("select COLUMN_NAME,column_comment from INFORMATION_SCHEMA.Columns where table_name='%s' and table_schema='%s'", tableName, dataBaseName);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            //System.out.println("tableName = [" + tableName + "]");
            while (rs.next()) {
                //System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                filedComments.put(underlineToCamel(rs.getString(1)), rs.getString(2));
            }
            //System.out.println("+++++++++++++++++++++++++++++");
            rs.close();
            tableFiledComments.put(tableName, filedComments);
        }

        stmt.close();
        conn.close();

        //System.out.println(tableFiledComments.toString());
        return tableFiledComments;

    }

    private static List<String> getTableName() throws SQLException{

        List<String> tableNames = new ArrayList<>();

        String url = urlMysql + dataBaseName;    //JDBC的URL
        Connection conn;

        conn = DriverManager.getConnection(url,username,passwordMysql);
        Statement stmt = conn.createStatement(); //创建Statement对象
        //System.out.println("成功连接到数据库！");

        String sql = "show tables";    //要执行的SQL
        ResultSet rs = stmt.executeQuery(sql);//创建数据对象
        //System.out.println("数据库名");
        while (rs.next()){
            //System.out.print(rs.getString(1));
            tableNames.add(rs.getString(1));
            //System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
        return tableNames;
    }

    public static void main(String[] args){
        try {
            //getTableFieldComments();
            //insertFieldComments(tableFiledComments);
            List<String> str = new ArrayList<>();
            str.add("system_role_resource_relation");
           // str.add("system_role");
            getFieldComments(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
