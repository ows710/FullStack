package com.score.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/CalScore")
public class CalScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = kor + eng + math;
		double avg = (double)sum/3;
		
		//{n:v, n:v}
		String res = "{\"name\":\""+name+"\", \"sum\":"+sum+", \"avg\":"+avg+"}";
		System.out.println(res);
		
		/*Map res = new HashMap();
		res.put("name", name);
		res.put("sum", sum);
		res.put("avg", avg);
		System.out.println(res);*/
		
		//json_simple.jar : 자바에서 json 처리하기 위한 라이브러리
		JSONObject obj = new JSONObject();		//json을 추상화한 클래스, HashMap을 상속
		obj.put("name", name);
		obj.put("sum", sum);
		obj.put("avg", avg);
		
		System.out.println(obj.toJSONString());
		
		PrintWriter out = response.getWriter();
		out.print(obj.toJSONString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

}
