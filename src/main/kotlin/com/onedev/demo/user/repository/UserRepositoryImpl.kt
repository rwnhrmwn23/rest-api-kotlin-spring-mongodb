package com.onedev.demo.user.repository

import com.mongodb.client.MongoCollection
import com.onedev.demo.database.DatabaseComponent
import com.onedev.demo.user.entity.User
import org.bson.conversions.Bson
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.setValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase("user").getCollection()

    override fun getUserByName(name: String): User? {
        return userCollection().findOne(User::name eq name)
    }

    override fun getUsers(): List<User> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String, major: String): List<User> {
        val newUser = User(name = name, major = major)
        val insert = userCollection().insertOne(newUser)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("Insert Gagal")
        }
    }

    override fun updateUser(id: String, name: String, major: String): List<User> {
        val listBson = ArrayList<Bson>()
        listBson.add(setValue(User::name, name))
        listBson.add(setValue(User::major, major))

        val update = userCollection().updateOne(User::id eq id, listBson)
        return if (update.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("Update Gagal")
        }
    }

    override fun deleteUser(id: String): List<User> {
        val delete = userCollection().deleteOne(User::id eq id)
        return if (delete.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("Delete Gagal")
        }
    }
}