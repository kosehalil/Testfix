package com.kosehalil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosehalil.model.ContactMessage;
import com.kosehalil.repository.ContactMessageRepository;
import com.kosehalil.repository.ContactMessageService;

@Controller
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    private final ContactMessageService service;

    public ContactController(ContactMessageService service, ContactMessageRepository contactMessageRepository) {
        this.service = service;
        this.contactMessageRepository = contactMessageRepository;
    }

    @PostMapping("/contact")
    public String sendMessage(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String phone,
                              @RequestParam String message) {

        ContactMessage msg = new ContactMessage();
        msg.setName(name);
        msg.setEmail(email);
        msg.setPhone(phone);
        msg.setMessage(message);

        service.save(msg);

        return "redirect:/contact?success";
    }
}
