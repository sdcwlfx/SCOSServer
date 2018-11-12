package esd.scos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import esd.scos.model.Food;

/**
 * Servlet implementation class FoodUpdateService
 */
@WebServlet("/FoodUpdateService")
public class FoodUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodUpdateService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Food newFood=new Food("�ƹϳ�����",10,13,"�Ȳ�");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String foodString=JSON.toJSONString(newFood);//���������json ��ʽ�ַ���
		System.out.println(foodString);
		
		JSONObject jsonNewFood=JSON.parseObject(foodString);//��String��jsonת���ɵ���JSON����
		JSONArray jsonArray=new JSONArray();//json����
		jsonArray.add(jsonNewFood);
		//response.getWriter().print(jsonNewFood);
		response.getWriter().print(jsonArray);//����app��json����
		System.out.println(jsonArray);
		System.out.println(jsonNewFood.get("foodPrice"));
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
