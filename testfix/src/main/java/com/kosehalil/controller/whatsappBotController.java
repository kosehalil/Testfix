package com.kosehalil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class whatsappBotController {

	@PostMapping("/webhook")
    public ResponseEntity<String> receiveMessage(@RequestBody String payload) {

        if (payload.contains("merhaba")) {
            
        }

        return ResponseEntity.ok("OK");
    }
}
