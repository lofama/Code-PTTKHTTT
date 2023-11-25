package dao;

import java.sql.*;

public class ConnectDAO_027 {
	    protected Connection connection;
	       public ConnectDAO_027() {
	    	   String url = "jdbc:mysql://localhost:3306/garaman027?useUnicode=true&characterEncoding=UTF-8";
	           String user = "root";
	           String password = "26072002";
	        try{
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, user, password);
	        }catch(Exception e){
	            System.out.println(e);
	        }
	    }
	}
