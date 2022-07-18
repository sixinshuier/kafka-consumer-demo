package com.consumer.demo.listener;

import com.alibaba.fastjson.JSON;
import com.consumer.demo.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message) {
        User user = (User) JSON.parse(message);
        System.out.println("User Name: " + user.getName());
        System.out.println("User Dept: " + user.getDept());
        System.out.println("User Salary: " + user.getSalary());
    }

}
