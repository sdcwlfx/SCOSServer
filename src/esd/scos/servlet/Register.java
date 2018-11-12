package esd.scos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import esd.scos.Util.Common;
import esd.scos.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		response.setCharacterEncoding("UTF-8");
		
		System.out.print(account+" lala  "+password);
		JSONObject jsonObject=new JSONObject();
		User user=new User(account,password);
		if(Common.registerUser(user)>0) {//×¢²á³É¹¦
			jsonObject.put("RESULTCODE", 1);
			response.getWriter().print(jsonObject);
			
		}else {//×¢²áÊ§°Ü
			jsonObject.put("RESULTCODE", 0);
			response.getWriter().print(jsonObject);
			
		}
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
