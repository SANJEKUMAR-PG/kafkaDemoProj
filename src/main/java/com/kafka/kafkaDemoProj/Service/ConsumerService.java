package com.kafka.kafkaDemoProj.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.kafka.kafkaDemoProj.Repo.ProductRepo;
import com.kafka.kafkaDemoProj.Repo.UserExtRepo;
import com.kafka.kafkaDemoProj.Repo.UserRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.kafka.kafkaDemoProj.Model.User;
import com.kafka.kafkaDemoProj.Model.Product;
import com.kafka.kafkaDemoProj.Model.UserExt;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties(prefix = "service")
public class ConsumerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private UserExtRepo userExtRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepo productRepo;

    NewTopic topic2 = TopicBuilder
            .name("Topic")
            .partitions(2)
            .replicas(3)
            .build();

    @KafkaListener(groupId = "group", topicPartitions = {
            @TopicPartition(topic = "Topic", partitions = {"0", "1"}),
            @TopicPartition(topic = "myTopic", partitions = {"0"})
    })
    public void listenMessages(ConsumerRecord<Object, Object> message) {
        UserExt userExt = UserExt.builder()
                .vMessagess(String.valueOf(message.value()))
                .build();
        userExtRepo.save(userExt);
    }


    @KafkaListener(groupId = "group", topicPartitions = {
            @TopicPartition(topic = "myTopic", partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0"),
                    @PartitionOffset(partition = "1", initialOffset = "0")})
    })
    public void listenMessage(ConsumerRecord<Object, Object> message) {
        UserExt userExt = UserExt.builder()
                .vMessagess(String.valueOf(message.value()))
                .build();
        userExtRepo.save(userExt);
    }


}


    @KafkaListener(groupId = "myGroup", topicPartitions = @TopicPartition(topic = "myTopic", partitions = "0"))
    public void consume(String input) throws JsonProcessingException {
        JSONObject object = new JSONObject(input);
        System.out.println(object);

        User user = User.builder()
                .iage(object.optInt("iage"))
                .vname(object.optString("vname"))
                .vMessage(object.optString("VMessage"))
                .build();

        userRepository.save(user);
    }

    @KafkaListener(groupId = "group", topicPartitions = {@TopicPartition(topic = "Topic", partitions = {"0", "1"})})
    public void consumeUser(ConsumerRecord<String, Object> input) throws JsonProcessingException {
        Object object = input.value();

        Gson gson = new Gson();
        User user = gson.fromJson(object.toString(), User.class);
        System.out.println(user);
        userRepository.save(user);
    }

    @KafkaListener(groupId = "group1", topicPartitions = {@TopicPartition(topic = "User", partitions = {"0", "1"})})
    public void consumeUser(ConsumerRecord<String, Object> input) throws JsonProcessingException {
        Object object = input.value();

        Gson gson = new Gson();
        User user = gson.fromJson(object.toString(), User.class);
        System.out.println(user);
    }

    @KafkaListener(groupId = "myGroup", topicPartitions = {@TopicPartition(topic = "myTopic", partitions = "0")})
    public void consumeProduct(ConsumerRecord<String, Object> input) throws JsonProcessingException {
        String key = input.key();
        Object value = input.value();

        if (key.equalsIgnoreCase("product")) {
            Gson gson = new Gson();
            Product product = gson.fromJson(value.toString(), Product.class);
            System.out.println(product);
            Product product1 = Product.builder()
                    .vProductName(product.getVProductName())
                    .iNoOfProduct(product.getINoOfProduct())
                    .productPrice(product.getProductPrice())
                    .build();
            productRepo.save(product1);
        }
        if (key.equalsIgnoreCase("user")) {
            Gson gson = new Gson();
            User user = gson.fromJson(value.toString(), User.class);
            System.out.println(user);
            userRepository.save(user);
        }
    }

    @KafkaListener(topics = "Topic", groupId = "group")
    public void listenMessage(String message) {
        UserExt userExt = UserExt.builder()
                .vMessagess(message)
                .build();
        userExtRepo.save(userExt);
    }

    @KafkaListener(groupId = "group1", topicPartitions = {@TopicPartition(topic = "topicName", partitions = {"0", "1", "2"})})
    public void consumeUserDetails(ConsumerRecord<String, Object> input) throws JsonProcessingException {
        String key = input.key();
        Object value = input.value();
        Gson gson = new Gson();

        if (key.equalsIgnoreCase("user")) {
            User user = gson.fromJson(value.toString(), User.class);
            System.out.println(user);
            userRepository.save(user);

            List<User> userList = userRepository.findByIage(user.getIage());
            userList.stream().forEach(user1 -> {
                Optional<Product> product = productRepo.findById(user1.getIProductId());
                kafkaTemplate.send("topicName", "product", product);
            });
        }
        if (key.equalsIgnoreCase("product")) {
            Product product = gson.fromJson(value.toString(), Product.class);
            Product product1 = Product.builder()
                    .iNoOfProduct(product.getINoOfProduct())
                    .vProductName(product.getVProductName())
                    .productPrice(product.getProductPrice())
                    .build();
            System.out.println(product1);
            productRepo.save(product1);
            String msg = "sfsdvd ur order details " + product1;
            kafkaTemplate.send("topicName", "userExt", msg);
        }
        if (key.equalsIgnoreCase("userExt")) {
            UserExt userExt = UserExt.builder()
                    .vMessagess(String.valueOf(input.value()))
                    .build();
            userExtRepo.save(userExt);
        }
    }


    /*else {
      Product product = gson.fromJson(value.toString(), Product.class);
      System.out.println(product);
      Product product1 = Product.builder()
              .iNoOfProduct(product.getINoOfProduct())
              .productPrice(product.getProductPrice())
              .vProductName(product.getVProductName())
              .build();
      productRepo.save(product1);
    }*/

    @KafkaListener(groupId = "group1", topicPartitions = {@TopicPartition(topic = "topicName", partitions = {"2"})})
    public void consumeUserDetail(ConsumerRecord<String, Object> input) throws JsonProcessingException {
        String key = input.key();
        Object value = input.value();

        Gson gson = new Gson();
        Product product = gson.fromJson(value.toString(), Product.class);
        System.out.println(product);
        Product product1 = Product.builder()
                .iNoOfProduct(product.getINoOfProduct())
                .productPrice(product.getProductPrice())
                .vProductName(product.getVProductName())
                .build();
        productRepo.save(product1);
    }
}
