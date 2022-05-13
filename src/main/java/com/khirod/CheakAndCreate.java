package com.khirod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheakAndCreate {
	public static final String CREATE_DATABASE= "create database ";
	
	//public static final String  CREATESTUDENTTABLE ="CREATE TABLE #$DBname#$.databasecollection(name varchar(200),parent_name varchar(200),city varchar(200),mobile_no bigint,primary key(student_id));";
	public static final String  CREATESTUDENTTABLE = "CREATE TABLE student_record(student_id int,name varchar(200),parent_name varchar(200),city varchar(200),mobile_no bigint,primary key(student_id))" ;
	//public static String use = "use";
	
	public static boolean isDBExists(String DBname) throws SQLException, ClassNotFoundException 
	{
		Connection con = Constant.getConnectoins();
		Statement stmt = con.createStatement();

		if (con != null) 
		{
			System.out.println("now we are cheacking database");
			ResultSet rs = con.getMetaData().getCatalogs();
			
			while (rs.next()) 
			{	
				String Catalogs = rs.getString(1);
				
				if (DBname.equals(Catalogs)) 
				{
					System.out.println(DBname + "database found");
					return true;
				}
			}
		}
		return false;

	}

	public static void createDB(String DBname) throws ClassNotFoundException, SQLException 
	{
		
		Connection con = Constant.getConnectoins();
		Statement stmt = con.createStatement();
		boolean isDbExiests = CheakAndCreate.isDBExists(DBname);
			if(isDbExiests==false) 
			{
				System.out.println("now creating a new database.");
				
				
				
				stmt.executeUpdate(CREATE_DATABASE+DBname);
				
				System.out.println("database is created");
				
				System.out.println("table is creating");
				
				createstudenttable(stmt,DBname);
				
				System.out.println("table and database both are created");
				
			}
			else
			{
				System.out.println("creating table while database is exiests");
				CheakAndCreate.createstudenttable(stmt,DBname);
			}
	}
	private static void createstudenttable(Statement stmt,String DBname) throws SQLException, ClassNotFoundException 
	{
		//stmt.executeUpdate("CREATESTUDENTTABLE");
		//stmt.executeUpdate(CREATE_DATABASE.replace(CREATESTUDENTTABLE,DBname));
		//System.out.println("table is created while database available");
		//stmt.executeUpdate(CREATE_TABLE+DBname+STUDENT_INFO);
		//stmt.close();
	}
	
}
