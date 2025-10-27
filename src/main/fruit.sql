CREATE TABLE FRUIT (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(50),
    PRICE INT,
    DESC_TEXT VARCHAR(200),
    IMAGE VARCHAR(100)
);

INSERT INTO FRUIT (NAME, PRICE, DESC_TEXT, IMAGE) VALUES
('いちご', 470, '甘くジューシーで中毒性最強。', 'images/itigo.jpg'),
('みかん', 430, '爽やかな口当たりの人気者。', 'images/mikan.jpg'),
('マスカット', 520, '控えめなのに抜群の存在感。', 'images/masukatto.jpg');
