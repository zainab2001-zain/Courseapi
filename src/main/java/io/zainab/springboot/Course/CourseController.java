package io.zainab.springboot.Course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.zainab.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService Courseservice;
    
	@RequestMapping("/topics/{id}/Courses")	
	public List<Course> getAllCourses(@PathVariable String id) {
		return Courseservice.getAllCourses(id);
	}
    
	@RequestMapping("/topics/{topicsid}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
    	return Courseservice.getCourse(id);
    } 
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicsid}/courses/")
	public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		Courseservice.addCourse(course);	
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicsid}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		Courseservice.updateCourse(course);	
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicsid}/courses/{id}")
	public void DeleteCourse(@PathVariable String id) {
		Courseservice.deleteCourse(id);
	}
    
}
