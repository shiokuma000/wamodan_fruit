package dao;
// データベース操作専用のクラス

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fruit;
// モデル層（Fruitクラス）を利用するためのimport。
// DBの1レコード＝Fruitインスタンスとして扱うために使用。

public class FruitDAO {

    // --- 定数（接続設定） ---
    // 相対パスに変更して、プロジェクト直下の data フォルダ内 DB に接続
    private static final String JDBC_URL = "jdbc:h2:./data/wamodan";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    // --- 全件取得メソッド ---
    public List<Fruit> findAll() {
        List<Fruit> fruits = new ArrayList<>();

        try {
            // --- ドライバ登録 ---
            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // try-with-resources で自動クローズ
        String sql = "SELECT NAME, PRICE, DESC_TEXT, IMAGE FROM FRUIT";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // SQL 実行
            ResultSet rs = pstmt.executeQuery();

            // 結果セットを1行ずつ処理
            while (rs.next()) {
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                String desc = rs.getString("DESC_TEXT");
                String image = rs.getString("IMAGE");
                fruits.add(new Fruit(name, price, desc, image));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fruits;
    }
}
