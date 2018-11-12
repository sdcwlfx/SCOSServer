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
 * 操作mySQL数据库
 * @author asus
 *
 */
public class DBHelper {

	private Connection conn;//数据库连接对象
	private Statement stmt;//sql语句执行对象
	
	private static final String driverName="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306";
	private static final String sDropDB="drop database if exists scosdb ";
	private static final String sCreateDB="create database scosdb";//创建数据库
	private static final String sSCOSDB="use scosdb";
	private static final String sDropTb="drop table if exists user";//删除表user
	private static final String sCreateTb="create table user (account varchar(20),password varchar(20))";
	private static final String sInsert="insert into user values('admin','123456')";//插入账户密码
	
	public DBHelper() {
		try {
			//加载MySQL驱动
			Class.forName(driverName);
			//与数据库建立连接
			conn=DriverManager.getConnection(url, "root", "admin");//root:用户名 admin：密码
			//初始化sql语句对象
			stmt=conn.createStatement();
			//stmt.execute(sDropDB);//如果数据库userdb存在先删除
			//stmt.execute(sCreateDB);//创建数据库userdb
			stmt.execute(sSCOSDB);//使用数据库userdb
			//stmt.execute(sDropTb);//如果user表存在则先删除
			//stmt.execute(sCreateTb);//创建user表
			//stmt.execute(sInsert);//向user表中插入一条数据
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查询某用户是否存在
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
	
	//注册app端用户,做了重复验证
	public int RegisterUser(User user) {
		System.out.println(user.getAccount()+"   "+user.getPassword());
		String sql="insert into User(account,password) values('"+user.getAccount()+"','"+user.getPassword()+"')";
		String sqlAccount="select * from User where account='"+user.getAccount()+"'";
		try {
			ResultSet rs=null;
			rs=stmt.executeQuery(sqlAccount);
			if(rs.next()) {
				return -1;//用户名已经存在
			}
			else {
				int sta=stmt.executeUpdate(sql);//成功注册返回1
				System.out.println("注册成功");
				return sta;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//获取所有凉菜
	public JSONArray  getAllColdFood() {
		
		JSONArray coldFoodList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from ColdFood");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//菜名
				int foodPrice=rs.getInt("foodPrice");//价格
				int foodStackNum=rs.getInt("foodStackNum");//库存
				String foodCategory=rs.getString("foodCategory");//类别
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
	
	//获取所有热菜
	public JSONArray getAllHotFood() {
			
		JSONArray hotFoodList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from HotFood");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//菜名
				int foodPrice=rs.getInt("foodPrice");//价格
				int foodStackNum=rs.getInt("foodStackNum");//库存
				String foodCategory=rs.getString("foodCategory");//类别
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
	
	//获取所有海鲜
	public JSONArray getAllSeaFood() {
		
		JSONArray seaFoodList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from SeaFood");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//菜名
				int foodPrice=rs.getInt("foodPrice");//价格
				int foodStackNum=rs.getInt("foodStackNum");//库存
				String foodCategory=rs.getString("foodCategory");//类别
				//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
				JSONObject seaFood=new JSONObject();
				seaFood.put("foodCategory", foodCategory);
				seaFood.put("foodStackNum", foodStackNum);
				seaFood.put("foodPrice", foodPrice);
				seaFood.put("foodName", foodName);
				seaFoodList.add(seaFood);
				
//				String foodName=rs.getString("foodName");//菜名
//				int foodPrice=rs.getInt("foodPrice");//价格
//				int foodStackNum=rs.getInt("foodStackNum");//库存
//				String foodCategory=rs.getString("foodCategory");//类别
//				Food seaFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//				seaFoodList.add(seaFood);
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seaFoodList;
	}
	
	//获取所有酒水
	public JSONArray getAllWine() {
		
		JSONArray wineList=new JSONArray();
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery("select * from Wine");
			while(rs.next()) {
				String foodName=rs.getString("foodName");//菜名
				int foodPrice=rs.getInt("foodPrice");//价格
				int foodStackNum=rs.getInt("foodStackNum");//库存
				String foodCategory=rs.getString("foodCategory");//类别
				//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
				JSONObject wine=new JSONObject();
				wine.put("foodCategory", foodCategory);
				wine.put("foodStackNum", foodStackNum);
				wine.put("foodPrice", foodPrice);
				wine.put("foodName", foodName);
				wineList.add(wine);
				
//				String foodName=rs.getString("foodName");//菜名
//				int foodPrice=rs.getInt("foodPrice");//价格
//				int foodStackNum=rs.getInt("foodStackNum");//库存
//				String foodCategory=rs.getString("foodCategory");//类别
//				Food wine=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//				wineList.add(wine);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wineList;
	}
	
	
	
	
	
	
	
	
	
	//获取所有实时凉菜名和库存量
		public JSONArray  getRealTimeColdFood() {
			
			JSONArray realTimeColdFoodList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from ColdFood");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//菜名
					//int foodPrice=rs.getInt("foodPrice");//价格
					int foodStackNum=rs.getInt("foodStackNum");//库存
					//String foodCategory=rs.getString("foodCategory");//类别
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
		
		//获取实时热菜名和库存量
		public JSONArray getRealTimeHotFood() {
				
			JSONArray realTimeHotFoodList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from HotFood");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//菜名
					//int foodPrice=rs.getInt("foodPrice");//价格
					int foodStackNum=rs.getInt("foodStackNum");//库存
					//String foodCategory=rs.getString("foodCategory");//类别
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
		
		//获取实时海鲜名和库存量
		public JSONArray getRealTimeSeaFood() {
			
			JSONArray realTimeSeaFoodList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from SeaFood");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//菜名
					//int foodPrice=rs.getInt("foodPrice");//价格
					int foodStackNum=rs.getInt("foodStackNum");//库存
					//String foodCategory=rs.getString("foodCategory");//类别
					//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
					JSONObject seaFood=new JSONObject();
					//seaFood.put("foodCategory", foodCategory);
					seaFood.put("foodStackNum", foodStackNum);
					//seaFood.put("foodPrice", foodPrice);
					seaFood.put("foodName", foodName);
					realTimeSeaFoodList.add(seaFood);
					
//					String foodName=rs.getString("foodName");//菜名
//					int foodPrice=rs.getInt("foodPrice");//价格
//					int foodStackNum=rs.getInt("foodStackNum");//库存
//					String foodCategory=rs.getString("foodCategory");//类别
//					Food seaFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
//					seaFoodList.add(seaFood);
					
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return realTimeSeaFoodList;
		}
		
		//获取实时酒水名和库存量
		public JSONArray getRealTimeWine() {
			
			JSONArray realTimeWineList=new JSONArray();
			ResultSet rs=null;
			try {
				rs=stmt.executeQuery("select * from Wine");
				while(rs.next()) {
					String foodName=rs.getString("foodName");//菜名
					//int foodPrice=rs.getInt("foodPrice");//价格
					int foodStackNum=rs.getInt("foodStackNum");//库存
					//String foodCategory=rs.getString("foodCategory");//类别
					//Food coldFood=new Food(foodName,foodPrice,foodStackNum,foodCategory);
					JSONObject wine=new JSONObject();
					//wine.put("foodCategory", foodCategory);
					wine.put("foodStackNum", foodStackNum);
					//wine.put("foodPrice", foodPrice);
					wine.put("foodName", foodName);
					realTimeWineList.add(wine);
					
//					String foodName=rs.getString("foodName");//菜名
//					int foodPrice=rs.getInt("foodPrice");//价格
//					int foodStackNum=rs.getInt("foodStackNum");//库存
//					String foodCategory=rs.getString("foodCategory");//类别
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
