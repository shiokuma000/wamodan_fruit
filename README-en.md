# 🍏 WamodanFruit – Fruit Management App

🌏 Language Switch: [日本語](README.md) | [English](README-en.md)

※Some parts may be hard to read due to translation.
---

## 👩‍💻 Technologies Used

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

## ✨ Overview

FruitManage is a fruit management application focused on **adding, listing, and deleting** fruits.  
Users can add new fruits or remove existing ones.

---

## 🎯 Key Features

| Feature | Description |
|--------|------------|
| 🍎 Add Fruit | Register a fruit with name, price, desc and image price via a form |
| 📋 List View | View all data in a clean format |
| ❌ Delete | Easily remove a fruit by specifying its name |
| 🧩 Three-Layer Structure | Maintains code with MVC and PRG patterns |

---

## 🚀 Setup

1. Clone this repository  
   `git clone https://github.com/shiokuma000/wamodan_fruit.git [your-folder-name]`

2. Import into Eclipse or other IDE  
   → **Select `FruitServlet` and run it on Tomcat**

3. Verify operation  
   - `http://localhost:8080/[your-folder-name]/FruitServlet`
  
4. How to Use

- **Toggle** → Click the 【❂】 at the top right to switch between light mode and dark mode.  
- **Add** → Register a fruit by entering its name, price, description, and image in the form at the right end.  

  (Please use images from the `images` folder. Example: `images/cherry.jpg`)

- **Delete** → Click the 【×】 at the top right of the image to remove it.


---

## 🔧 Technical Details

| Layer | Description |
|-------|------------|
| Controller | Handles only page navigation and request routing |
| Model | Consolidates validation and processing logic |
| DAO | Safely executes SQL using PreparedStatement |
| DB | Managed with a simple FRUIT table |
| View | Minimal forms and list constructed with JSP |

---

## 🔄 Improvements & Future Tasks

| Item | Details |
|------|--------|
| 🍏 Edit Function | Plan to add the ability to edit registered fruits |
| 🔍 Search | Improve to allow filtering by name or color |
| 📸 Upload Improvements | Enable image uploads in file format |


---

## 🗄️ ER Diagram (Text Version)

FRUIT

├─ ID INT AUTO_INCREMENT (PK)  
├─ NAME VARCHAR(50) UNIQUE  
├─ PRICE INT  
├─ DESC_TEXT VARCHAR(200)  
└─ IMAGE VARCHAR(200)

---

## 📚 Project Structure & Documentation

- [🪄 Project Structure](PROJECT.md)  
- [🔑 List View Design Document](document/INDEX.md)  
- [📝 Add Fruit Design Document](document/ADD.md)  
- [✏️ Delete Fruit Design Document](document/DELETE.md)  
- [🌗 SQL Initialization Design Document](document/DBInit.md)  

---

## 🚀 Demo

| Toggle |   | Add |   | Delete |
|--------|---|-----|---|--------|
| <img src="assets/toggle.GIF" width="350" /> |   | <img src="assets/add.GIF" width="280" /> |   | <img src="assets/delete.GIF" width="300" /> |

---

## 💡 License & Copyright

- This project was created for learning purposes and is not intended for commercial use.  
- Licenses of various libraries and tools belong to their respective authors.

---

## 📸 Image Credits

All images sourced from Pixabay.

- Strawberry: ds_30  
- Mandarin: minka2507  
- Muscat: yoyo61  
- Peach: RitaE  
- Cherry: ulleo  

Many thanks to the photographers for their wonderful images.

---

## 🗓️ Last Updated

2025-11-26

---

## 🌟 Special Thanks

To everyone who offered insights during my learning, and to those viewing this project,  
a small token of my gratitude.









