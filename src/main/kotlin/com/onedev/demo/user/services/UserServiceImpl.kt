package com.onedev.demo.user.services

import com.onedev.demo.user.entity.User
import com.onedev.demo.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getIds(): List<String> {
        return userRepository.getUsers().map { it.id }
    }

    override fun getUsers(): List<User> {
        return userRepository.getUsers()
    }

    override fun getUserByName(name: String): User? {
        return userRepository.getUserByName(name)
    }

    override fun addUser(user: User): List<User> {
        return userRepository.addUser(user.name, user.major)
    }

    override fun updateUser(id: String, user: User): List<User> {
        return userRepository.updateUser(id, user.name, user.major)
    }

    override fun deleteUser(id: String): List<User> {
        return userRepository.deleteUser(id)
    }

}