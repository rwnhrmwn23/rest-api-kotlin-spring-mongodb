package com.onedev.demo.user.controller

import com.onedev.demo.BaseResponse
import com.onedev.demo.user.entity.User
import com.onedev.demo.user.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/ids")
    fun getIds(): BaseResponse<List<String>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.getIds()
        )
    }

    @GetMapping
    fun getUsers(): BaseResponse<List<User>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.getUsers()
        )
    }

    @GetMapping("/{name}")
    fun getUserByName(
        @PathVariable("name") name: String
    ): BaseResponse<User> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.getUserByName(name)
        )
    }

    @PostMapping
    fun addUser(
        @RequestBody user: User
    ): BaseResponse<List<User>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.addUser(user)
        )
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable("id") id: String,
        @RequestBody user: User,
    ): BaseResponse<List<User>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.updateUser(id, user)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable("id") id: String
    ): BaseResponse<List<User>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = userService.deleteUser(id)
        )
    }
}