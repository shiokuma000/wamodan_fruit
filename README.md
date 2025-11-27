# 🍏 WamodanFruit – 果物管理アプリ
---

## 👩‍💻 使用技術

<p align="left">
  <!-- Frontend -->
  <img src="https://img.shields.io/badge/HTML-3A3A3A.svg?style=for-the-badge&logoColor=white" />
  <img src="https://img.shields.io/badge/CSS-3A3A3A.svg?style=for-the-badge&logoColor=white" />
  <img src="https://img.shields.io/badge/JavaScript-3A3A3A.svg?style=for-the-badge&logoColor=white" />

  <!-- Backend -->
  <img src="https://img.shields.io/badge/Java-1E1E1E.svg?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Servlet%2FJSP-1E1E1E.svg?style=for-the-badge&logo=java&logoColor=white" />

  <!-- Tools / DB -->
  <img src="https://img.shields.io/badge/H2%20Database-000000.svg?style=for-the-badge&logo=h2&logoColor=white" />
  <img src="https://img.shields.io/badge/Apache%20Tomcat-000000.svg?style=for-the-badge&logo=apache-tomcat&logoColor=white" />
  <img src="https://img.shields.io/badge/Git-000000.svg?style=for-the-badge&logo=git&logoColor=white" />
  <img src="https://img.shields.io/badge/GitHub-000000.svg?style=for-the-badge&logo=github&logoColor=white" />
</p>

---

## ✨ 概要

FruitManage は、果物の **登録・一覧・削除** を中心にした
果物管理アプリです。
ユーザーは果物の追加・削除を行うことができます

---

## 🎯 主な特徴

| 機能 | 説明 |
|------|------|
| 🍎 果物登録 | 名前・色・価格をフォームから登録 |
| 📋 一覧表示 | 全データを整ったテーブル形式で確認 |
| ❌ 削除機能 | 名前指定でかんたん削除 |
| 🧩 三層構造 | MVC,PRGで保守性向上 |

---

## 🚀 セットアップ

1. このリポジトリを clone  
   `git clone  https://github.com/shiokuma000/wamodan_fruit.git 任意のフォルダ名 `

2. Eclipseなどへインポート  
   → ** `FruitServlet`を選択して Tomcat で実行**

3. 動作確認  
   - `http://localhost:8080/(付けてくださったフォルダ名)/FruitServlet`

---

## 🔧 技術的工夫

| レイヤー | 説明 |
|----------|------|
| Controller | 画面遷移とリクエストの振り分けのみを担当 |
| Service | バリデーションと処理ロジックを集約 |
| DAO | PreparedStatement で SQL を安全に実行 |
| DB | シンプルな fruit テーブルで管理 |
| View | JSP で最小限のフォーム・一覧を構築 |

---

## 🔄 今後の改善案

| 項目 | 内容 |
|------|------|
| 🍏 編集機能 | 登録済み果物の編集を追加 |
| 🔍 検索機能 | 名前や色での絞り込み |
| 📦 カテゴリ | カテゴリテーブルを追加した多対一化 |

---


## 🗄️ ER 図 (テキスト版)


FRUIT

├─ ID INT AUTO_INCREMENT (PK)

├─ NAME VARCHAR(50) UNIQUE

├─ PRICE INT

├─ DESC_TEXT VARCHAR(200)

└─ IMAGE VARCHAR(200)

## 📚 プロジェクト構成・設計書一覧

- [🪄 プロジェクト構成](PROJECT.md)
- [🔑 一覧表示処理設計書](document/INDEX.md)  
- [📝 追加処理設計書](document/ADD.md)   
- [✏️ 削除処理設計書](document/DELETE.md)  
- [🌗 SQL初期化処理設計書](document/DBInit.md)    

---

## 🚀 動作例

| 切り替え |   | 追加 |   | 削除 |
|-----------|---|------|---|------|
| <img src="assets/toggle.GIF" width="350" /> |   | <img src="assets/add.GIF" width="250" /> |   | <img src="assets/delete.GIF" width="300" /> |

※画像をクリックすると拡大表示されます。


---

## 💡ライセンスと著作権

- このプロジェクトは学習目的で作成したものであり、商用利用は想定しておりません。
- 各種ライブラリ・ツールのライセンスはそれぞれの作者に帰属します。

---

## 📸 引用

画像はすべてPixabayから引用させていただきました！

- いちご：ds_30様
- みかん：minka2507様
- マスカット：yoyo61様
- 桃：RitaE様
- さくらんぼ：ulleo様

上記の方々の素敵なお写真をお借りいたしました、ありがとうございます。

---

## 🗓️ 最終更新日

2025-11-26

---

## 🌟 Special Thanks

学習の中で多くの気づきをくださった皆さまへ、  
ささやかではございますが、感謝を込めて。
