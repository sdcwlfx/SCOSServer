package esd.scos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import esd.scos.Util.Common;
import esd.scos.model.User;

/**
 * app端登陆验证，登陆成功返回app端{“RESULTCODE”：1} ，登陆失败返回app端{“RESULTCODE”：0}
 * Servlet implementation class LoginValidator
 */
@WebServlet("/LoginValidator")
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		
		response.setCharacterEncoding("UTF-8");
		
		JSONObject jsonObject=new JSONObject();//单个JSON对象
		User user=new User(account,password);
		
		if(Common.isValidUser(user)) {//判断账号密码正确
			jsonObject.put("RESULTCODE",1);
			response.getWriter().print(jsonObject);
		}else {
			jsonObject.put("RESULTCODE", 0);
			response.getWriter().print(jsonObject);
		}
	
	
	}
	

}
