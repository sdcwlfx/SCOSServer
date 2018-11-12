package esd.scos.Util;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;

import esd.scos.DB.DBHelper;
import esd.scos.model.Food;
import esd.scos.model.User;

public class Common {

	private static DBHelper db=new DBHelper();
	
	//登录验证
	public static Boolean isValidUser(User user) {
		
		return db.QueryUser(user); 
	}
	
	//app端注册,并做了重复验证
	public static int registerUser(User user) {
		
		return db.RegisterUser(user);
	}
	
	//获取所有凉菜
	public static JSONArray getAllColdFood(){
		
		return db.getAllColdFood();
	}
	
	//获取所有热菜
	public static JSONArray getAllHotFood(){
		
		return db.getAllHotFood();
	}
	
	//获取所有海鲜
	public static JSONArray getAllSeaFood(){
		
		return db.getAllSeaFood();
	}
	
	
	//获取说有酒水
	public static JSONArray getAllWine(){
		
		return db.getAllWine();
	}
	
	
	//获取实时数据凉菜名和库存量
	public static JSONArray getRealTimeColdFood(){
			
		return db.getRealTimeColdFood();
	}
		
	//获取实时数据热菜名和库存量
	public static JSONArray getRealTimeHotFood(){
			
		return db.getRealTimeHotFood();
	}
		
	//获取实时数据海鲜名和库存量
	public static JSONArray getRealTimeSeaFood(){
			
		return db.getRealTimeSeaFood();
	}
		
		
	//获取实时数据酒水名和库存量
	public static JSONArray getRealTimeWine(){
			
		return db.getRealTimeWine();
	}
	
	
	
}
