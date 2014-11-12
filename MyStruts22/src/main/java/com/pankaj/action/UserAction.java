package com.pankaj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pankaj.model.User;

public class UserAction{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	public String execute(){
		
		return "success";
	}
	
public String getObject(){
		
		return "success";
	}
public String getJsonData() throws IOException{
	
	 
	    HttpServletResponse response = ServletActionContext.getResponse();
	   ServletContext context = ServletActionContext.getServletContext();

	
		   JSONObject result = new JSONObject();
	        response.setContentType("application/json");
	        response.setHeader("Cache-Control", "no-store");
	        result.put("name", "pankaj");
	        result.put("city", "satna");
	        PrintWriter out = response.getWriter();
	        out.print(result);
	        System.out.println("in listHR" + result.toString());
	        return null;

}

public String getJsonArrayData() throws IOException{
	
	 
    HttpServletResponse response = ServletActionContext.getResponse();
   ServletContext context = ServletActionContext.getServletContext();


	   JSONObject result = new JSONObject();
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
     
        PrintWriter out = response.getWriter();
        List<String> list=new ArrayList<String>();
        list.add("jan");
        list.add("feb");
        list.add("mar");
        JSONArray.writeJSONString(list, out);
        System.out.println("\n"+list.toString());
        return null;

}

public String getJsonMixData() throws IOException{
	
	 
    HttpServletResponse response = ServletActionContext.getResponse();
   ServletContext context = ServletActionContext.getServletContext();


	   JSONObject result = new JSONObject();
	   JSONArray values=new JSONArray();
	   Map value;
	   value=new HashMap();
	   value.put("name","pankaj");
	   value.put("age", 25);
	   values.add(value);
	   value=new HashMap();
	   value.put("name","sat");
	   value.put("age", 10);
	   values.add(value);
	   value=new HashMap();
	   value.put("name","pak");
	   value.put("age", 30);
	   values.add(value);
	  
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
     
        PrintWriter out = response.getWriter();
        result.put("data", values);
        result.put("msg","student data");
        out.print(result);
        System.out.println("\n"+result.toString());
        return null;

}
}
