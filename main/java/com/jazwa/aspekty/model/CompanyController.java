package com.jazwa.aspekty.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")

public class CompanyController {

    @GetMapping("/{podany_tekst}")
    ResponseEntity<Message> getMessage(@PathVariable("podany_tekst") String podany_tekst){
        Message message = new Message();
        message.setMessage(podany_tekst);
        return ResponseEntity.ok().body(message);
    }

    @GetMapping
    ResponseEntity<List<Message>> dispMessages(){
        List<Message> messages = new ArrayList<>();
        Message message1 = new Message();
        Message message2 = new Message();
        Message message3 = new Message();

        message1.setMessage("message 1");
        message2.setMessage("message 2");
        message3.setMessage("message 3");

        messages.add(message1);
        messages.add(message2);
        messages.add(message3);

        return ResponseEntity.ok().body(messages);
    }
}
