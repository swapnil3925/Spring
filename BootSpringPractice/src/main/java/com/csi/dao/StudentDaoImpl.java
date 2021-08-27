package com.csi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csi.model.Student;

@Component
public class StudentDaoImpl implements StrudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static final String SELECTALL_SQL = "select * from student";
	public static final String SELECTBYID_SQL = "select * from student where studid=?";
	public static final String INSERT_SQL = "insert into student(studid,studname,studcontactnumber,studemailid,studaddress)values(?,?,?,?,?)";
	public static final String UPDATE_SQL = "update student set studname=?,studcontactnumber=?,studemailid=?,studaddress=? where studid=?";
	public static final String DELETEALL_SQL = "delete from student";
	public static final String DELETEBYID_SQL = "delete from student where studid=?";

	Student student(ResultSet rs, int rowInt) throws SQLException {
		return Student.builder().studId(rs.getInt(1)).studName(rs.getString(2)).studContactNumber(rs.getLong(3))
				.studEmailId(rs.getString(4)).studAddress(rs.getString(5)).build();
	}

	@Override
	public List<Student> getAllData() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECTALL_SQL, this::student);
	}

	@Override
	public Student getDataById(int studId) {
		// TODO Auto-generated method stub
		return (Student) jdbcTemplate.query(SELECTBYID_SQL, this::student,studId).get(0);
	}

	@Override
	public void saveData(Student student) {
		// TODO Auto-generated method stub'
		jdbcTemplate.update(INSERT_SQL, student.getStudId(), student.getStudName(), student.getStudContactNumber(),
				student.getStudEmailId(), student.getStudAddress());

	}

	@Override
	public void saveBulkData(List<Student> students) {
		// TODO Auto-generated method stub
		for (Student cc : students) {
			jdbcTemplate.update(INSERT_SQL, cc.getStudId(), cc.getStudName(), cc.getStudContactNumber(),
					cc.getStudEmailId(), cc.getStudAddress());
		}

	}

	@Override
	public void updateData(int studId,Student student) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE_SQL, student.getStudName(),student.getStudContactNumber(),student.getStudEmailId(),student.getStudAddress(),studId);

	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETEALL_SQL);
	}

	@Override
	public void deleteDataById(int studId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETEBYID_SQL, studId);

	}

}
