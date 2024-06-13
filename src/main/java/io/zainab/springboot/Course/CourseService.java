package io.zainab.springboot.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> Courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)	
		.forEach(Courses::add);
		return Courses;
	}
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course Course) {
		courseRepository.save(Course);
		
	}
	public void updateCourse(Course Course) {
		//for(int i=0;i<topics.size();i++) {
			//Topic t=topics.get(i);
			//if(t.getId().equals(id)) {
				//topics.set(i, topic);
				//return;
			//}
		//}

		courseRepository.save(Course);
	}
	public void deleteCourse(String id) {// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
