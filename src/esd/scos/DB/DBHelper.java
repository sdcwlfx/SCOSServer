package esd.scos.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import esd.scos.model.Food;
import esd.scos.model.User;

/**
 * ����mySQL���ݿ�
 * @author asus
 *
 */
public class DBHelper {

	private Connection conn;//���ݿ����Ӷ���
	private Statement stmt;//sql���ִ�ж���
	
	private static final String driverName="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306";
	private static final String sDropDB="drop database if exists scosdb ";
	private static final String sCreateDB="create database scosdb";//�������ݿ�
	private static final String sSCOSDB="use scosdb";
	private static final String sDropTb="drop table if exists user";//ɾ����user
	private static final String sCreateTb="create table user (account varchar(20),password varchar(20))";
	private static final String sInsert="insert into user values('admin','123456')";//�����˻�����
	
	public DBHelper() {
		try {
			//����MySQL����
			Class.forName(driverName);
			//�����ݿ⽨������
			conn=DriverManager.getConnection(url, "root", "admin");//root:�û��� admin������
			//��ʼ��sql������
			stmt=conn.createStatement();
			//stmt.execute(sDropDB);//������ݿ�userdb������ɾ��
			//stmt.execute(sCreateDB);//�������ݿ�userdb
			stmt.execute(sSCOSDB);//ʹ�����ݿ�userdb
			//stmt.execute(sDropTb);//���user���������ɾ��
			//stmt.execute(sCreateTb);//����user��
			//stmt.execute(sInsert);//��user���в���һ������
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//��ѯĳ�û��Ƿ����
	public Boolean QueryUser(User user) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from User where account='"+user.getAccount()+"' and password='"+user.getPassword()+"'");
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//ע��app���û�,�����ظ���֤
	public int RegisterUser(User user) {
		System.out.println(user.getAccount()+"   "+user.getPassword());
		String sql="insert into User(account,password) values('"+user.getAccount()+"','"+user.getPassword()+"')";
		String sqlAccount="select * from User where account='"+user.getAccount()+"'";
		try {
			ResultSet rs=null;
			rs=stmt.executeQuery(sqlAccount);
			if(rs.next()) {
				return -1;//�û����Ѿ�����
			}
			else {
				int sta=stmt.executeUpdate(sql);//�ɹ�ע�᷵��1
				System.out.println("ע��ɹ�");
				return sta;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//��ȡ��������
	public JSONArray  getAllColdFood() {
		
		JSONArray coldFoodList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from ColdFood");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//����
				int foodPrice=rs.getInt("foodPrice");//�۸�
				int foodStackNum=rs.getInt("foodStackNum");//���
				String foodCategory=rs.getString("foodCategory");//���
				//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
				JSONObject coldFood=new JSONObject();
				coldFood.put("foodCategory", foodCategory);
				coldFood.put("foodStackNum", foodStackNum);
				coldFood.put("foodPrice", foodPrice);
				coldFood.put("foodName", foodName);
				coldFoodList.add(coldFood);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coldFoodList;
	}
	
	//��ȡ�����Ȳ�
	public JSONArray getAllHotFood() {
			
		JSONArray hotFoodList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from HotFood");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//����
				int foodPrice=rs.getInt("foodPrice");//�۸�
				int foodStackNum=rs.getInt("foodStackNum");//���
				String foodCategory=rs.getString("foodCategory");//���
				//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
				JSONObject hotFood=new JSONObject();
				hotFood.put("foodCategory", foodCategory);
				hotFood.put("foodStackNum", foodStackNum);
				hotFood.put("foodPrice", foodPrice);
				hotFood.put("foodName", foodName);
				hotFoodList.add(hotFood);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return hotFoodList;
	}
	
	//��ȡ���к���
	public JSONArray getAllSeaFood() {
		
		JSONArray seaFoodList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from SeaFood");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//����
				int foodPrice=rs.getInt("foodPrice");//�۸�
				int foodStackNum=rs.getInt("foodStackNum");//���
				String foodCategory=rs.getString("foodCategory");//���
				//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
				JSONObject seaFood=new JSONObject();
				seaFood.put("foodCategory", foodCategory);
				seaFood.put("foodStackNum", foodStackNum);
				seaFood.put("foodPrice", foodPrice);
				seaFood.put("foodName", foodName);
				seaFoodList.add(seaFood);
				
//				String foodName=rs.getString("foodName");//����
//				int foodPrice=rs.getInt("foodPrice");//�۸�
//				int foodStackNum=rs.getInt("foodStackNum");//���
//				String foodCategory=rs.getString("foodCategory");//���
//				Food seaFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//				seaFoodList.add(seaFood);
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seaFoodList;
	}
	
	//��ȡ���о�ˮ
	public JSONArray getAllWine() {
		
		JSONArray wineList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from Wine");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//����
				int foodPrice=rs.getInt("foodPrice");//�۸�
				int foodStackNum=rs.getInt("foodStackNum");//���
				String foodCategory=rs.getString("foodCategory");//���
				//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
				JSONObject wine=new JSONObject();
				wine.put("foodCategory", foodCategory);
				wine.put("foodStackNum", foodStackNum);
				wine.put("foodPrice", foodPrice);
				wine.put("foodName", foodName);
				wineList.add(wine);
				
//				String foodName=rs.getString("foodName");//����
//				int foodPrice=rs.getInt("foodPrice");//�۸�
//				int foodStackNum=rs.getInt("foodStackNum");//���
//				String foodCategory=rs.getString("foodCategory");//���
//				Food wine=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//				wineList.add(wine);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wineList;
	}
	
	
	
	
	
	
	
	
	
	//��ȡ����ʵʱ�������Ϳ����
		public JSONArray  getRealTimeColdFood() {
			
			JSONArray realTimeColdFoodList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from ColdFood");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//����
					//int foodPrice=rs.getInt("foodPrice");//�۸�
					int foodStackNum=rs.getInt("foodStackNum");//���
					//String foodCategory=rs.getString("foodCategory");//���
					//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
					JSONObject coldFood=new JSONObject();
					//coldFood.put("foodCategory", foodCategory);
					coldFood.put("foodStackNum", foodStackNum);
					//coldFood.put("foodPrice", foodPrice);
					coldFood.put("foodName", foodName);
					realTimeColdFoodList.add(coldFood);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return realTimeColdFoodList;
		}
		
		//��ȡʵʱ�Ȳ����Ϳ����
		public JSONArray getRealTimeHotFood() {
				
			JSONArray realTimeHotFoodList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from HotFood");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//����
					//int foodPrice=rs.getInt("foodPrice");//�۸�
					int foodStackNum=rs.getInt("foodStackNum");//���
					//String foodCategory=rs.getString("foodCategory");//���
					//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
					JSONObject hotFood=new JSONObject();
					//hotFood.put("foodCategory", foodCategory);
					hotFood.put("foodStackNum", foodStackNum);
					//hotFood.put("foodPrice", foodPrice);
					hotFood.put("foodName", foodName);
					realTimeHotFoodList.add(hotFood);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return realTimeHotFoodList;
		}
		
		//��ȡʵʱ�������Ϳ����
		public JSONArray getRealTimeSeaFood() {
			
			JSONArray realTimeSeaFoodList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from SeaFood");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//����
					//int foodPrice=rs.getInt("foodPrice");//�۸�
					int foodStackNum=rs.getInt("foodStackNum");//���
					//String foodCategory=rs.getString("foodCategory");//���
					//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
					JSONObject seaFood=new JSONObject();
					//seaFood.put("foodCategory", foodCategory);
					seaFood.put("foodStackNum", foodStackNum);
					//seaFood.put("foodPrice", foodPrice);
					seaFood.put("foodName", foodName);
					realTimeSeaFoodList.add(seaFood);
					
//					String foodName=rs.getString("foodName");//����
//					int foodPrice=rs.getInt("foodPrice");//�۸�
//					int foodStackNum=rs.getInt("foodStackNum");//���
//					String foodCategory=rs.getString("foodCategory");//���
//					Food seaFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//					seaFoodList.add(seaFood);
					
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return realTimeSeaFoodList;
		}
		
		//��ȡʵʱ��ˮ���Ϳ����
		public JSONArray getRealTimeWine() {
			
			JSONArray realTimeWineList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from Wine");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//����
					//int foodPrice=rs.getInt("foodPrice");//�۸�
					int foodStackNum=rs.getInt("foodStackNum");//���
					//String foodCategory=rs.getString("foodCategory");//���
					//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
					JSONObject wine=new JSONObject();
					//wine.put("foodCategory", foodCategory);
					wine.put("foodStackNum", foodStackNum);
					//wine.put("foodPrice", foodPrice);
					wine.put("foodName", foodName);
					realTimeWineList.add(wine);
					
//					String foodName=rs.getString("foodName");//����
//					int foodPrice=rs.getInt("foodPrice");//�۸�
//					int foodStackNum=rs.getInt("foodStackNum");//���
//					String foodCategory=rs.getString("foodCategory");//���
//					Food wine=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//					wineList.add(wine);
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return realTimeWineList;
		}
	
	
	
		
	
	
	
	
	
}
