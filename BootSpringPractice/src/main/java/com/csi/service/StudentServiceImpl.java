package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.StrudentDao;
import com.csi.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StrudentDao studentDaoImpl;

	@Override
	public List<Student> getAllData() {
		// TODO Auto-generated method stub
		return studentDaoImpl.getAllData();
	}

	@Override
	public Student getDataById(int studId) {
		// TODO Auto-generated method stub
		return studentDaoImpl.getDataById(studId);
	}

	@Override
	public void saveData(Student student) {
		// TODO Auto-generated method stub
		studentDaoImpl.saveData(student);
	}

	@Override
	public void saveBulkData(List<Student> students) {
		// TODO Auto-generated method stub
		studentDaoImpl.saveBulkData(students);
	}

	@Override
	public void updateData(int studId, Student student) {
		// TODO Auto-generated method stub
		studentDaoImpl.updateData(studId, student);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		studentDaoImpl.deleteAllData();
	}

	@Override
	public void deleteDataById(int studId) {
		// TODO Auto-generated method stub
		studentDaoImpl.deleteDataById(studId);
	}

}
