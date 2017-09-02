package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by guotao on 2017/8/29.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.util
 * wenzhouintelligentgas
 */
public class getGPSData {

    private static String urlMysql = "jdbc:mysql://localhost:3306/";
    private static String dataBaseName = "wen_zhou_intelligent_gas";
    private static String username = "root";
    private static String passwordMysql = "MKhaha_05050909";

    private static String tableFieldCommentTableName = "deliver_car_location";


    public static void main(String[] args) {

        String[] deliverId = {"1", "2", "3", "4", "5"};

        try {
            for (String id : deliverId) {
                String filePath = "E:\\03.data\\temp\\car\\00" + id + "\\Trajectory\\";
                File file = new File(filePath);
                File[] fileArray = file.listFiles();

                for (File fileItem : fileArray) {
                    System.out.println("fileItem : " + fileItem.getAbsolutePath());
                    FileReader fr = new FileReader(fileItem);
                    BufferedReader bf = new BufferedReader(fr);
                    insertDataToMysql(Integer.parseInt(id), bf);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertDataToMysql(int id, BufferedReader bufferedReader) throws SQLException, IOException, ClassNotFoundException, ParseException {
        //调用Class.forName()方法加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("成功加载MySQL驱动！");

        String url = urlMysql + dataBaseName;    //JDBC的URL
        Connection conn;
        int count = 0;

        conn = DriverManager.getConnection(url, username, passwordMysql);
        conn.setAutoCommit(true);
        System.out.println("成功连接到数据库！");

        PreparedStatement pstmt;
        String sql = String.format("INSERT INTO %s (id, timestamp, latitude, longitude) VALUES(?, ?, ?, ?); ",
                tableFieldCommentTableName);

        pstmt = (PreparedStatement) conn.prepareStatement(sql);

        String line = null;

        // skip 前六行
        {
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
        }

        while (null != (line = bufferedReader.readLine())) {
            String[] infos = line.split(",");
            if (infos.length < 5)   continue;
            pstmt.setInt(1, id);

            Timestamp timestamp = Timestamp.valueOf(infos[5] + " " + infos[6]);
            pstmt.setTimestamp(2, timestamp);
            pstmt.setString(3, infos[0]+10);
            pstmt.setString(4, infos[1]+4);
            pstmt.executeUpdate();
            count++;
        }
        System.out.println("All down : " + count);
        conn.close();
    }
}
