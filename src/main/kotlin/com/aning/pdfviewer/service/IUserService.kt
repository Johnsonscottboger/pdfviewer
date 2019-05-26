package com.aning.pdfviewer.service

import com.aning.pdfviewer.entity.User

/**
 * 提供对 [User] 实体操作的集合
 */
public interface IUserService {

    /**
     * 注册 [User] 实例
     * @param user 注册的用户
     */
    public fun register(user: User);

    /**
     * 根据 [id] 获取 [User] 记录
     * @param id 指定的 id
     * @return [User] 记录
     */
    public fun getById(id: Long): User?

    /**
     * 根据 [email] 和 [password] 获取 [User] 记录
     * @param email 指定的邮箱
     * @param password 指定的密码
     * @return [User] 记录
     */
    public fun getByEmailAndPassword(email: String, password: String): User?

    /**
     * 获取 [email] 是否已存在
     * @param email 指定的邮箱
     * @return 指定的 [email] 是否存在
     */
    public fun getIsExists(email: String): Boolean;

    /**
     * 修改 [User] 记录
     * @param user 指定修改的记录
     */
    public fun update(user: User);
}