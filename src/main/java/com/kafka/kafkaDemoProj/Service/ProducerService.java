
package com.kafka.kafkaDemoProj.Service;

import com.kafka.kafkaDemoProj.Model.User;
import com.kafka.kafkaDemoProj.Model.Product;
import com.kafka.kafkaDemoProj.Repo.ProductRepo;
import com.kafka.kafkaDemoProj.Repo.UserRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties(prefix = "service")
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepo productRepo;

    @Bean
    public NewTopic generalTopic() {
        return TopicBuilder.name("topicName")
                .partitions(3)
                .replicas(3)
                .build();
    }

    NewTopic topic2 = TopicBuilder
            .name("Topic")
            .partitions(2)
            .replicas(3)
            .build();


    public void sendUserToKafka(int iAge) {

        List<String> messages = new ArrayList<>();
        List<User> input = userRepository.findByIage(iAge);
        input.stream().forEach(msg -> {
            String message = "hi" + "  " + msg.getVname() + "  " + "your age is " + msg.getIage() + " with message" + "  " + msg.getVMessage();
            messages.add(message);
        });


        messages.stream().forEach(sms -> {
            kafkaTemplate.send(topic2.name(), sms);
        });


        kafkaTemplate.send(topic2.name(), messages.get(0));

        System.out.println("success");

    }


    public void send(User input) {
        JSONObject jsonObject = new JSONObject(input);
        System.out.println(jsonObject);
        kafkaTemplate.send("myTopic", String.valueOf(jsonObject));
        List<User> user = userRepository.findByIage(input.getIage());
        jsonObject.put("User", user);
        user.stream().forEach(user1 -> {
            kafkaTemplate.send("myTopic", String.valueOf(jsonObject));
        });
    }


    public User sendUser(@RequestBody User input) {
        kafkaTemplate.send(topic2.name(), "user", input);
        return input;
    }

    public User sendUser(@RequestBody User input) {

        kafkaTemplate.send("myTopic", "user", input);

        Optional<Product> product = productRepo.findById(input.getIProductId());
        kafkaTemplate.send("myTopic", "product", product);
        kafkaTemplate.send("Topic", "userExt", input.getVname());
        Optional<Product> product = productRepo.findById(input.getIProductId());
        kafkaTemplate.send(topic2.name(), topic2.numPartitions(), "product", product);
        kafkaTemplate.send(topic2.name(), topic2.numPartitions(), "user", input);
        Optional<Product> product = productRepo.findById(input.getIProductId());
        kafkaTemplate.send(topic2.name(), "product", product);
        return input;
    }

    public User send(@RequestBody User input) {
        Optional<Product> product = productRepo.findById(input.getIProductId());
        kafkaTemplate.send("topicName", "user", input);
        kafkaTemplate.send("topicName", "product", product);
        kafkaTemplate.send("topicName", "user", input);
        kafkaTemplate.send("topicName", "product", product);
        return input;
    }
}

