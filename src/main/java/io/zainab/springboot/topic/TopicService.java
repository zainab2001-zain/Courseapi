package io.zainab.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	private List<Topic> topics=new ArrayList<>( Arrays.asList(
			new Topic("spring","spring framework","spring framework description"),
			new Topic("java","core java","core java description"),
			new Topic("javascript","javascript","javascript description")
			));
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll()	
		.forEach(topics::add);
		return topics;
	}
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}
	public void updatetopic(Topic topic, String id) {
		//for(int i=0;i<topics.size();i++) {
			//Topic t=topics.get(i);
			//if(t.getId().equals(id)) {
				//topics.set(i, topic);
				//return;
			//}
		//}

		topicRepository.save(topic);
	}
	public void deleteTopic(String id) {// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
