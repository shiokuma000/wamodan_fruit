# 追加処理設計書

## 1. 概要
果物管理アプリの追加処理について記述する。  
追加は AddFruitServlet 内で `action=add` を判定して実行する。  
処理完了後は一覧表示サーブレット（FruitServlet）へリダイレクトする。

---

## 2. 画面操作
- 追加フォームに必要項目を入力し「送信」ボタン押下  
- 以下のパラメータが POST 送信される  
  - action = add  
  - name, price, desc_text, image（追加する果物の情報）

   ### 2-1. 処理フロー図
[![追加処理図](drawio/add.png)](drawio/add.png)

※ 画像をクリックすると拡大表示されます。

**色分け情報：**  
- Controller → 赤 
- Model → 青  
- SQLテーブル   →  黄

---

## 3. AddFruitServlet（POST処理）

### 3-1. action 判定
`action` が "add" の場合、追加処理へ進む。

### 3-2. 追加データ取得
- `String name = request.getParameter("name");`  
- `String price = request.getParameter("price");`  
- `String desc = request.getParameter("desc_text");`  
- `String image = request.getParameter("image");`

### 3-3. DAO 呼び出し
`FruitDAO dao = new FruitDAO();`  
`dao.insert(new Fruit(name, price, desc, image));`

---

## 4. FruitDAO.insert

### 4-1. 概要
新しい果物レコードを FRUIT テーブルに追加する。

### 4-2. SQL
`INSERT INTO FRUIT (NAME, PRICE, DESC_TEXT, IMAGE) VALUES (?, ?, ?, ?)`

### 4-3. 処理内容
- PreparedStatement を使用して追加 SQL を実行  
- 正常終了後、呼び出し元へ戻る

---

## 5. FRUIT テーブル
追加対象は NAME, PRICE, DESC_TEXT, IMAGE を含む新しい行。

---

## 6. 追加後処理（リダイレクト）
追加完了後、一覧画面へ戻るため `response.sendRedirect("FruitServlet");` を実行する。

---

