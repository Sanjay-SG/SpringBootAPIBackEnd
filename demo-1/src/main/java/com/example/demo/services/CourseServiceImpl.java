package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	
	List<Course> list;
	
	public CourseServiceImpl() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<>();
		list.add(new Course(123, "Java", "JEE"));
		list.add(new Course(124, "Spring", "Rest API"));
		list.add(new Course(125, "Python", "Python Course"));
		list.add(new Course(126, "JS", "Javascript"));
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c = null;
		
		for(Course course:list)
		{
			if(course.getId() == courseId)
			{
				c = course;
				break;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}
	
	

}
