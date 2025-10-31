package dao; 
// データベース操作専用のクラス

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Fruit;
// モデル層（Fruitクラス）を利用するためのimport。
// DBの1レコード＝Fruitインスタンスとして扱うために使用。

public class FruitDAO {
   
	// --- 定数（接続設定） ---
    // JDBC接続URL：H2データベースの保存場所
    private static final String JDBC_URL = "jdbc:h2:~/desktop/h2/wamodan"; 

    // データベースのユーザー名
    private static final String DB_USER = "sa";

    // データベースのパスワード
    private static final String DB_PASS = "";


    // --- 全件取得メソッド ---
    // FRUITテーブルにある全ての果物情報を取り出すメソッド。
    // 呼び出し元（Servletなど）にList<Fruit>として返す。
    public List<Fruit> findAll() {
        List<Fruit> fruits = new ArrayList<>();
        

        try {
            // --- ドライバ登録 ---
            Class.forName("org.h2.Driver");
            
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }

            // try-with-resourcesで自動クローズ
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                 Statement stmt = conn.createStatement()) {
            	
            	// SQL文定義
                String sql = "SELECT NAME, PRICE, DESC_TEXT, IMAGE FROM FRUIT";
                
             // SQLを実行し、結果をResultSetで受け取る
                ResultSet rs = stmt.executeQuery(sql);
                
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
