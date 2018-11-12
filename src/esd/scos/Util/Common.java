package esd.scos.Util;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;

import esd.scos.DB.DBHelper;
import esd.scos.model.Food;
import esd.scos.model.User;

public class Common {

	private static DBHelper db=new DBHelper();
	
	//��¼��֤
	public static Boolean isValidUser(User user) {
		
		return db.QueryUser(user); 
	}
	
	//app��ע��,�������ظ���֤
	public static int registerUser(User user) {
		
		return db.RegisterUser(user);
	}
	
	//��ȡ��������
	public static JSONArray getAllColdFood(){
		
		return db.getAllColdFood();
	}
	
	//��ȡ�����Ȳ�
	public static JSONArray getAllHotFood(){
		
		return db.getAllHotFood();
	}
	
	//��ȡ���к���
	public static JSONArray getAllSeaFood(){
		
		return db.getAllSeaFood();
	}
	
	
	//��ȡ˵�о�ˮ
	public static JSONArray getAllWine(){
		
		return db.getAllWine();
	}
	
	
	//��ȡʵʱ�����������Ϳ����
	public static JSONArray getRealTimeColdFood(){
			
		return db.getRealTimeColdFood();
	}
		
	//��ȡʵʱ�����Ȳ����Ϳ����
	public static JSONArray getRealTimeHotFood(){
			
		return db.getRealTimeHotFood();
	}
		
	//��ȡʵʱ���ݺ������Ϳ����
	public static JSONArray getRealTimeSeaFood(){
			
		return db.getRealTimeSeaFood();
	}
		
		
	//��ȡʵʱ���ݾ�ˮ���Ϳ����
	public static JSONArray getRealTimeWine(){
			
		return db.getRealTimeWine();
	}
	
	
	
}
