package com.onedev.demo.user.repository

import com.onedev.demo.user.entity.User

interface UserRepository {
    fun getUsers(): List<User>
    fun getUserByName(name: String): User?
    fun addUser(name: String, major: String): List<User>
    fun updateUser(id: String, name: String, major: String): List<User>
    fun deleteUser(id: String): List<User>
}