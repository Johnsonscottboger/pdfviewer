package com.aning.pdfviewer.controller

import com.aning.pdfviewer.entity.User
import com.aning.pdfviewer.model.ResultMessage
import com.aning.pdfviewer.model.ValueResultMessage
import com.aning.pdfviewer.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private lateinit var _userService: IUserService

    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     */
    @PostMapping("/login")
    public fun login(email: String, password: String): ResultMessage {
        val user = this._userService.getByEmailAndPassword(email, password)
        return if (user == null) {
            ResultMessage(false, "邮箱或密码错误")
        } else {
            ValueResultMessage(true, value = user.id)
        }
    }

    /**
     * 注册
     * @param name 名称
     * @param email 邮箱
     * @param password 密码
     */
    @PostMapping("/register")
    public fun register(name: String, email: String, password: String): ResultMessage {
        val exists = this._userService.getIsExists(email)
        return if (exists) {
            ResultMessage(false, "邮箱已存在")
        } else {
            val user = User(name = name, email = email, password = password)
            this._userService.register(user)
            ValueResultMessage(true, value = user.id)
        }
    }
}