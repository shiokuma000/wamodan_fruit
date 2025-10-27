package test; 
// テスト専用。実運用コードと分ける。

import java.util.List;

import dao.FruitDAO;
import model.Fruit;

/**
 * FruitDAOTestクラス
 * データベース接続とSELECT文の実行確認を行う。
 * コンソールに全レコードを出力して動作をチェックする。
 */
public class FruitDAOTest {
    public static void main(String[] args) {

        System.out.println("=== FruitDAO 全件取得テスト開始 ===");

        // DAOのインスタンスを生成
        FruitDAO dao = new FruitDAO();

        // findAll()メソッドを呼び出し、結果を受け取る
        List<Fruit> fruitList = dao.findAll();

        // データが取得できているか確認
        if (fruitList.isEmpty()) {
            System.out.println("データがありません。");
        } else {
            System.out.println("取得件数：" + fruitList.size());
            System.out.println("--- 取得データ一覧 ---");
            // 1件ずつコンソールに出力
            for (Fruit f : fruitList) {
                System.out.println("名前：" + f.getName());
                System.out.println("価格：" + f.getPrice() + "円");
                System.out.println("説明：" + f.getDesc());
                System.out.println("画像：" + f.getImage());
                System.out.println("---------------------------");
            }
        }

        System.out.println("=== テスト終了 ===");
    }
}
