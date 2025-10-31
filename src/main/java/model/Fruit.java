package model;
import java.io.Serializable;

public class Fruit implements Serializable{
	private String name;
	private int price;
	private String desc; // 説明文
	private String image;

	// --- デフォルトコンストラクタ（JSPやDAOで必要になることがある） ---
	public Fruit() {}
		public Fruit(String name,int price,String desc,String image) {
			this.name = name;
			this.price = price;
			this.desc = desc;
			this.image = image;
	}
		
	// --- Getter（JSPのEL式やDAOから参照される） ---
	public String getName() {return name;}
	public int getPrice() {return price;}
	public String getDesc() { return desc; }
	public String getImage() {return image;}
	
}	