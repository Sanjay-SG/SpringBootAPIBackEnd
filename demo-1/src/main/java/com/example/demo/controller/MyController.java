package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;

@RestController
public class MyController 
{
	@Autowired
	private CourseService cs;
	@GetMapping("/home")
	public String home()
	{
		return "Welcome.";
	}
	
	@CrossOrigin
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.cs.getCourses();
	}
	
	@CrossOrigin
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.cs.getCourse(Long.parseLong(courseId));
	}
	
	@CrossOrigin
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		
		return this.cs.addCourse(course);
	}
	
	//update course
	@CrossOrigin
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.cs.updateCourse(course);
	}
	
	//delete the course
	@CrossOrigin
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try
		{
			this.cs.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e1)
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
}
