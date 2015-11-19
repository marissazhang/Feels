package com.mie.dao;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Symp_Res;
import com.mie.model.Symptom;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class ResourceDao {
	
	private Connection connection;

	public ResourceDao() {
		connection = DbUtil.getConnection();
	}

	//method to return all resources for symptoms selected
	public List<Symp_Res> getResources(Enumeration symptomList) {
		
		List<Symp_Res> sympResList = new ArrayList<Symp_Res>();
		
		//while loop ensures that we only go through available symptoms
		while (symptomList.hasMoreElements()) {
		
			
			//try clause to create SQL queries --> only returns resources for one symptom per run (since we're filtering by symptom)
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT SympName, ResourceName FROM SympXRes WHERE sympName=?");
				// Parameters start with 1
				preparedStatement.setString(1, (String)symptomList.nextElement());
				
				//store results in a resultset
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					Symp_Res sympRes = new Symp_Res();
					sympRes.setSymptomName(rs.getString("SympName"));
					sympRes.setResourceName(rs.getString("ResourceName"));
					sympResList.add(sympRes);
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
	
		return sympResList;
		
	}
	
	public List<Symp_Res> getAllResources() {
		
		List<Symp_Res> sympResList = new ArrayList<Symp_Res>();
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT SympName, ResourceName FROM SympXRes");
				System.out.println("TESTING function get all RESOURCES");
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					Symp_Res sympRes = new Symp_Res();
					sympRes.setSymptomName(rs.getString("SympName"));
					sympRes.setResourceName(rs.getString("ResourceName"));
					sympResList.add(sympRes);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return sympResList;
	}
}