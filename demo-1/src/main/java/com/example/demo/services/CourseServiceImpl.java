package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	
//	List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	
	public CourseServiceImpl() {
		
		// TODO Auto-generated constructor stub
		/*
		 * list = new ArrayList<>(); list.add(new Course(123, "Java", "JEE"));
		 * list.add(new Course(124, "Spring", "Rest API")); list.add(new Course(125,
		 * "Python", "Python Course")); list.add(new Course(126, "JS", "Javascript"));
		 */
		
		
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		/*
		 * Course c = null;
		 * 
		 * for(Course course:list) { if(course.getId() == courseId) { c = course; break;
		 * } }
		 */
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		
		courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		/*
		 * list.forEach(e -> { if(e.getId() == course.getId()) {
		 * e.setId(course.getId()); e.setTitle(course.getTitle());
		 * e.setDescription(course.getDescription()); } });
		 */
		
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long courseId) {
		// TODO Auto-generated method stub
//		list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
		
		Course entity = courseDao.getOne(courseId);
		
		courseDao.delete(entity);
	}
	
	

}
