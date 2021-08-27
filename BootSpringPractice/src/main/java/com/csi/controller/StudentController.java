package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.exception.Duplicate;
import com.csi.exception.InvalidParameter;
import com.csi.exception.RecordNotfoundException;
import com.csi.model.Student;
import com.csi.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentServiceImpl;

	@GetMapping("/getalldata")
	public List<Student> getAllData() {
		return studentServiceImpl.getAllData();
	}

	@GetMapping("/getdatabyid/{studId}")
	public Student getDataById(@PathVariable int studId) throws RecordNotfoundException {
		boolean flag = false;

		for (Student s : studentServiceImpl.getAllData()) {
			if (s.getStudId() == studId) {
				flag = true;
			}
		}
		if (flag == false) {
			throw new RecordNotfoundException("Student doest exits...");
		}

		return studentServiceImpl.getDataById(studId);
	}

	@PostMapping("/savedata")
	public String saveData(@RequestBody Student student) throws InvalidParameter, Duplicate {
		boolean flag = false;
		if (student.getStudName() != null) {
			flag = true;
		} else {
			throw new InvalidParameter("plz check spelling of empName");
		}

		if (student.getStudContactNumber() != 0) {
			flag = true;
		} else {
			throw new InvalidParameter("plz check spelling of studContactNumber");
		}

		if (student.getStudEmailId() != null) {
			flag = true;
		} else {
			throw new InvalidParameter("plz check spelling of studEmailId");
		}

		if (student.getStudAddress() != null) {
			flag = true;
		} else {
			throw new InvalidParameter("plz check spelling of studAddress");
		}
		for (Student s : studentServiceImpl.getAllData()) {
			if (student.getStudContactNumber() == s.getStudContactNumber()) {
				throw new Duplicate("contact number Already used...");
			} else if (student.getStudEmailId().equals(s.getStudEmailId())) {
				throw new Duplicate("email id already in used...");
			}
		}
		studentServiceImpl.saveData(student);
		return "data saved successfully";
	}

	@PostMapping("/savebulkofdata")
	public String saveBulkOfData(@RequestBody List<Student> students) {
		studentServiceImpl.saveBulkData(students);
		return "bulk of data saved successfully";
	}

	@PutMapping("/updatedata/{studId}")
	public String updateData(@PathVariable int studId, @RequestBody Student student) throws RecordNotfoundException {
		boolean flag = false;
		for (Student s : studentServiceImpl.getAllData()) {
			if (s.getStudId() == studId) {
				flag = true;
			}
		}
		if (flag == false) {
			throw new RecordNotfoundException("student does not exit");
		}
		studentServiceImpl.updateData(studId, student);
		return "update data successfully";
	}

	@DeleteMapping("/deletealldata")
	public String deleteAll() {
		studentServiceImpl.deleteAllData();
		return "Deleted All data successfully";
	}

	@DeleteMapping("/deletebyid/{studId}")
	public String deleteById(@PathVariable int studId) throws RecordNotfoundException {
		boolean flag = false;
		for (Student s : studentServiceImpl.getAllData()) {
			if (s.getStudId() == studId) {
				flag = true;
			}
		}
		if (flag == false) {
			throw new RecordNotfoundException("student does not exits");
		}
		studentServiceImpl.deleteDataById(studId);
		return "data deleted successfully";
	}
}
