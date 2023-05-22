package EmployeeTask_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

@WebServlet("/EmployeeInput")
public class EmployeeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 StringBuffer jb= new StringBuffer();
		 String line=null;
		 BufferedReader reader=request.getReader();
		 while((line=reader.readLine())!= null) {
			jb.append(line);			
		 }
		 JSONObject jsobj = new JSONObject(jb.toString());
		 response.setContentType("application/json");
		 PrintWriter out = response.getWriter();
		 EmployeeHash emhash=new EmployeeHash();
		 int empId=jsobj.getInt("empId");
		 String empName=jsobj.getString("empName");
		 int empSalary=jsobj.getInt("empSalary");
		 String empType=jsobj.getString("empType");
		 emhash.add(empId, empName, empSalary, empType);
		 out.println("Added");
		 out.println(EmployeeHash.permanentHashtable.toString());
		 out.println(EmployeeHash.partTimeHashtable.toString());
		 out.println(EmployeeHash.contractHashtable.toString());		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Gson gson=new Gson();
		 response.setContentType("application/json");
         PrintWriter out = response.getWriter();
         EmployeeHash emhash=new EmployeeHash();
		 int id=Integer.parseInt(request.getParameter("empId"));
		 Object ob=emhash.checkId(id);
         String s=gson.toJson(ob);
         out.print(s);		
	}
}
