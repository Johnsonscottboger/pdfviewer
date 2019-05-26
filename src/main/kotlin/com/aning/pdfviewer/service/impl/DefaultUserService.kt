package com.aning.pdfviewer.service.impl

import com.aning.pdfviewer.dao.IUserDao
import com.aning.pdfviewer.entity.User
import com.aning.pdfviewer.service.IUserService
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * 提供对 [User] 实体操作的集合的默认实现
 */
@Service
public class DefaultUserService : IUserService {

    @Resource
    private lateinit var _userDao: IUserDao

    /**
     * 注册 [User] 实例
     * @param user 注册的用户
     */
    override fun register(user: User) {
        this._userDao.add(user)
    }

    /**
     * 根据 [id] 获取 [User] 记录
     * @param id 指定的 id
     * @return [User] 记录
     */
    override fun getById(id: Long): User? {
        return this._userDao.getById(id)
    }

    /**
     * 根据 [email] 和 [password] 获取 [User] 记录
     * @param email 指定的邮箱
     * @param password 指定的密码
     * @return [User] 记录
     */
    override fun getByEmailAndPassword(email: String, password: String): User? {
        return this._userDao.getByEmailAndPassword(email, password)
    }

    /**
     * 获取 [email] 是否已存在
     * @param email 指定的邮箱
     * @return 指定的 [email] 是否存在
     */
    override fun getIsExists(email: String): Boolean {
        return this._userDao.getIsExists(email)
    }

    /**
     * 修改 [User] 记录
     * @param user 指定修改的记录
     */
    override fun update(user: User) {
        this._userDao.update(user)
    }
}