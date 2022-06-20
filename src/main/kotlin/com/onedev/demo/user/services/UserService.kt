package com.onedev.demo.user.services

import com.onedev.demo.user.entity.User

interface UserService {
    fun getIds(): List<String>
    fun getUsers(): List<User>
    fun getUserByName(name: String): User?
    fun addUser(user: User): List<User>
    fun updateUser(id: String, user: User): List<User>
    fun deleteUser(id: String): List<User>
}