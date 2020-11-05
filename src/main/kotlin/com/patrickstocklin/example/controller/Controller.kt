package com.patrickstocklin.example.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Controller {

    @GetMapping("/hello")
    fun blog(model: Model): String {
        model["title"] = "My Blog"
        return "blog"
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<String> {
        return ResponseEntity("UP", HttpStatus.OK)
    }

}