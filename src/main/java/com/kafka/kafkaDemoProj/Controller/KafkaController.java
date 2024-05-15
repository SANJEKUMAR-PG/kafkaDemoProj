
package com.kafka.kafkaDemoProj.Controller;

import com.kafka.kafkaDemoProj.Repo.UserRepository;
import com.kafka.kafkaDemoProj.Service.ConsumerService;
import com.kafka.kafkaDemoProj.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.kafka.kafkaDemoProj.Model.*;


@RestController
@RequestMapping("api/v2/kafka")
@CrossOrigin
@Validated
public class KafkaController {

    @Autowired
    private ProducerService producer;

    @Autowired
    private ConsumerService consumer;


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/produce")
    public void sendMessageToKafka(@RequestParam(value = "message") String message) {
        producer.sendMessage(message);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void sendUserToKafka(@RequestParam(value = "iAge", defaultValue = "0") int iAge) {
        producer.sendUserToKafka(iAge);
    }

    @GetMapping("receive/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getMessages(@PathVariable int id, String message) {
        consumer.getMessages(id, message);
    }

    @PostMapping("user")
    public User sendUser(@RequestBody User input) {
        producer.sendUser(input);
        return input;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody User input) {
        producer.send(input);
    }

}

