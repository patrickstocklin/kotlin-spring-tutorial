package com.patrickstocklin.example.controller

import com.patrickstocklin.example.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class Controller(val userService: UserService) {

    @GetMapping("/hello")
    fun blog(model: Model): String {
        model["title"] = "My Blog"
        return "blog"
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<String> {
        return ResponseEntity("UP", HttpStatus.OK)
    }

    @GetMapping("/user/{userId}")
    fun getUser(@PathVariable userId: Long): ResponseEntity<String> {
        userService.getUser(userId)
        return ResponseEntity(userId.toString(), HttpStatus.OK)
    }

    @PostMapping("/user")
    fun createUser(): ResponseEntity<String> {
        userService.createUser(0L)
        return ResponseEntity("CREATE", HttpStatus.CREATED)
    }

}