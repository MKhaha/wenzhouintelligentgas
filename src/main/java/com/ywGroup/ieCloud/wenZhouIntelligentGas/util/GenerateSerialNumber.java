package com.ywGroup.ieCloud.wenZhouIntelligentGas.util;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guotao on 2017/8/31.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.util
 * wenzhouintelligentgas
 */
public class GenerateSerialNumber {

    private static String urlMysql = "jdbc:mysql://localhost:3306/";
    private static String dataBaseName = "wen_zhou_intelligent_gas";
    private static String username = "root";
    private static String passwordMysql = "MKhaha_05050909";

    private static String[] tableName = {"company", "gas_station", "gas_bottle_manager"};


    private static String getCrc(byte[] data) {
        int high;
        int flag;

        // 16位寄存器，所有数位均为1
        int wcrc = 0xffff;
        for (int i = 0; i < data.length; i++) {
            // 16 位寄存器的高位字节
            high = wcrc >> 8;
            // 取被校验串的一个字节与 16 位寄存器的高位字节进行“异或”运算
            wcrc = high ^ data[i];

            for (int j = 0; j < 8; j++) {
                flag = wcrc & 0x0001;
                // 把这个 16 寄存器向右移一位
                wcrc = wcrc >> 1;
                // 若向右(标记位)移出的数位是 1,则生成多项式 1010 0000 0000 0001 和这个寄存器进行“异或”运算
                if (flag == 1)
                    wcrc ^= 0xa001;
            }
        }

        return Integer.toHexString(wcrc);
    }

    private static void generateSerialNumberForTable() throws Exception {
        //调用Class.forName()方法加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("成功加载MySQL驱动！");

        String url = urlMysql + dataBaseName;    //JDBC的URL
        Connection conn;
        int count = 0;

        conn = DriverManager.getConnection(url, username, passwordMysql);
        conn.setAutoCommit(true);
        System.out.println("成功连接到数据库！");
        String administrativeRegionYueQing = "330382";

        for (String table : tableName) {
            if (table.equals("company")) {


                Statement stmt = conn.createStatement(); //创建Statement对象
                Map<Integer, String> mapIdToSerialNumber = new HashMap<>();

                String selectSql = String.format("select id, company_number, administrative_region from %s", table);
                ResultSet rs = stmt.executeQuery(selectSql);//创建数据对象
                //System.out.println("tableName = [" + tableName + "]");
                while (rs.next()) {
                    //System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                    String combination = "gs" + rs.getString(3) + rs.getString(2);
                    mapIdToSerialNumber.put(rs.getInt(1), combination + getCrc(combination.getBytes()));
                }
                //System.out.println("+++++++++++++++++++++++++++++");
                rs.close();
                stmt.close();

                String updateSql = String.format("update %s set serial_number=? where id=?", table);
                PreparedStatement pstmt;
                pstmt = conn.prepareStatement(updateSql);
                for (Map.Entry<Integer, String> item : mapIdToSerialNumber.entrySet()) {
                    pstmt.setInt(2, item.getKey());
                    pstmt.setString(1, item.getValue());
                    pstmt.addBatch();

                }
                pstmt.executeBatch();
                pstmt.close();
            } else if (table.equals("gas_station")) {
                Statement stmt = conn.createStatement(); //创建Statement对象
                Map<Integer, String> mapIdToSerialNumber = new HashMap<>();

                String selectSql = String.format("select id, code, administrative_region, parent_company from %s", table);
                ResultSet rs = stmt.executeQuery(selectSql);//创建数据对象
                //System.out.println("tableName = [" + tableName + "]");
                while (rs.next()) {
                    //System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                    String combination = "qz" + rs.getString(3) + rs.getString(4) + rs.getString(2);
                    mapIdToSerialNumber.put(rs.getInt(1), combination + getCrc(combination.getBytes()));
                }
                //System.out.println("+++++++++++++++++++++++++++++");
                rs.close();
                stmt.close();

                String updateSql = String.format("update %s set serial_number=? where id=?", table);
                PreparedStatement pstmt;
                pstmt = conn.prepareStatement(updateSql);
                for (Map.Entry<Integer, String> item : mapIdToSerialNumber.entrySet()) {
                    pstmt.setInt(2, item.getKey());
                    pstmt.setString(1, item.getValue());
                    pstmt.addBatch();

                }
                pstmt.executeBatch();
                pstmt.close();


            } else if (table.equals("gas_bottle_manager")) {
                Statement stmt = conn.createStatement(); //创建Statement对象
                Map<Integer, String> mapIdToSerialNumber = new HashMap<>();

                String selectSql = String.format("select id, cylinder_barcode from %s", table);
                ResultSet rs = stmt.executeQuery(selectSql);//创建数据对象
                //System.out.println("tableName = [" + tableName + "]");
                while (rs.next()) {
                    //System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                    String combination = "qp" + administrativeRegionYueQing + "000005" + "000001" + rs.getString(2);
                    mapIdToSerialNumber.put(rs.getInt(1), combination + getCrc(combination.getBytes()));
                }
                //System.out.println("+++++++++++++++++++++++++++++");
                rs.close();
                stmt.close();

                String updateSql = "update gas_bottle_manager set serial_number=? where id=?";
                PreparedStatement pstmt;
                pstmt = conn.prepareStatement(updateSql);
                for (Map.Entry<Integer, String> item : mapIdToSerialNumber.entrySet()) {
                    pstmt.setInt(2, item.getKey());
//                    pstmt.setInt(2, Integer.parseInt(administrativeRegionYueQing));
                    pstmt.setString(1, item.getValue());

                    pstmt.addBatch();

                }
                pstmt.executeBatch();
                pstmt.close();

            } else {
                System.out.println("ERROR++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
        System.out.println("All down : " + count);
        conn.close();
    }

    public static void main(String[] args) {
        try {
            generateSerialNumberForTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
