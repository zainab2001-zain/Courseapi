package io.zainab.springboot.Course;

import io.zainab.springboot.topic.Topic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String desciption;
	
	@ManyToOne
	private Topic topic;
	public Course(	) {
		
	}
	public Course(String id, String name, String desciption,String topicID) {
		super();
		this.id = id;
		this.name = name;
		this.desciption = desciption;
		this.topic=new Topic(topicID,"","");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
