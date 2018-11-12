package esd.scos.model;

import java.io.Serializable;
/**
 * ��Ʒ��Ϣ
 * @author asus
 *
 */
public class Food implements Serializable{
	
	
	private String foodName;//����
	private int foodPrice;//�˼۸�
	private int foodStackNum;//�����
	private String foodCategory;//���
	 
	public Food(String foodName,int foodPrice,int foodStackNum,String foodCategory) { 
		this.foodName=foodName;
		this.foodPrice=foodPrice;
		this.foodStackNum=foodStackNum;
		this.foodCategory=foodCategory;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getFoodStackNum() {
		return foodStackNum;
	}
	public void setFoodStackNum(int foodStackNum) {
		this.foodStackNum = foodStackNum;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	 
	 

}
