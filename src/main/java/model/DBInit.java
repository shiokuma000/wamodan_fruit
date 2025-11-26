package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBInit {

	// アプリケーション全体で使う DB パス
    public static String dataFolderPath;

    // --- DB 接続 ---
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("org.h2.Driver");
        // 絶対パスを使うように変更
        String dbPath = dataFolderPath + "/wamodan";
        return DriverManager.getConnection("jdbc:h2:" + dbPath + ";AUTO_SERVER=TRUE", "sa", "");

        // プロジェクト直下 data フォルダ内 DB を使用
//        return DriverManager.getConnection("jdbc:h2:./data/wamodan;AUTO_SERVER=TRUE", "sa", "");
    }



    public static void initialize() {

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // --- FRUIT テーブル作成 ---
            String sqlFruitTable =
                "CREATE TABLE IF NOT EXISTS FRUIT (" +
                "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "NAME VARCHAR(50) UNIQUE, " +
                "PRICE INT, " +
                "DESC_TEXT VARCHAR(200), " +
                "IMAGE VARCHAR(200)" +
                ")";
            stmt.execute(sqlFruitTable);

            // --- 初期データ挿入 ---
            insertIfNotExists(conn, "いちご", 470, "甘くジューシーで中毒性最強。", "images/itigo.jpg");
            insertIfNotExists(conn, "みかん", 430, "爽やかな口当たりの人気者。", "images/mikan.jpg");
            insertIfNotExists(conn, "マスカット", 520, "控えめなのに抜群の存在感。", "images/masukatto.jpg");

            System.out.println("FRUIT テーブル初期化完了");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- PreparedStatement で存在確認＆挿入 ---
    private static void insertIfNotExists(Connection conn, String name, int price, String desc, String image) throws SQLException {
        String sql = "INSERT INTO FRUIT(NAME, PRICE, DESC_TEXT, IMAGE) " +
                     "SELECT ?, ?, ?, ? " +
                     "WHERE NOT EXISTS (SELECT * FROM FRUIT WHERE NAME = ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setString(3, desc);
            pstmt.setString(4, image);
            pstmt.setString(5, name);

            pstmt.executeUpdate();
        }
    }
}
