package com.csi.dao;

import java.util.List;

import com.csi.model.Student;

public interface StrudentDao {
	
		public List<Student> getAllData();
		
		public Student getDataById(int studId);
		
		public void saveData(Student student);
		
		public void saveBulkData(List<Student> students);
		
		public void updateData(int studId,Student student);
		
		public void deleteAllData();
		
		public void deleteDataById(int studId);
}
