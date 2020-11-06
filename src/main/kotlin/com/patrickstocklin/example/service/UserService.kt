package com.patrickstocklin.example.service

import com.patrickstocklin.example.domain.User
import org.springframework.stereotype.Service

@Service
class UserService {

    fun getUser(userId: Long) : User {
        return User(userId, "Sammy")
    }

    fun createUser(userId: Long) : User {
        return User(userId, "Patty")
    }

}