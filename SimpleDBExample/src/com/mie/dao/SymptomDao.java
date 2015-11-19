package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mie.model.Symptom;
import com.mie.util.DbUtil;

public class SymptomDao {
	
	private Connection connection;

	public SymptomDao() {
		connection = DbUtil.getConnection();
	}

	
	public List<Symptom> getAllSymptoms() {
	List<Symptom> symptoms = new ArrayList<Symptom>();
	try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from Symptoms");
		while (rs.next()) {
			Symptom symptom = new Symptom();
			symptom.setSymptomid(rs.getInt("SymptomID"));
			symptom.setSymptomName(rs.getString("Symptom_Name"));
			symptoms.add(symptom);
	
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return symptoms;
}
	
}