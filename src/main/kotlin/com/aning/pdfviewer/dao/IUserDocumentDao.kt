package com.aning.pdfviewer.dao

import com.aning.pdfviewer.entity.Document
import com.aning.pdfviewer.entity.User
import com.aning.pdfviewer.entity.UserDocument

/**
 * 提供对 [UserDocument] 实体操作的方法集合
 */
public interface IUserDocumentDao {

    /**
     * 添加 [UserDocument] 记录
     * @param userDocument 添加的 [UserDocument] 实例
     */
    public fun add(userDocument: UserDocument)

    /**
     * 删除 [UserDocument] 记录
     * @param userId 指定的用户 id
     * @param documentId 指定的文档 id
     */
    public fun delete(userId: Long, documentId: Long)

    /**
     * 根据 [userId] 获取所有 [Document] 实例
     * @param userId 指定的用户 id
     * @return [Document] 实例
     */
    public fun getAllByUserId(userId: Long): List<Document>

    /**
     * 根据 [documentId] 获取 [User] 实例
     * @param documentId 指定的文档 id
     * @return [User] 实例
     */
    public fun getAllByDocumentId(documentId: Long): List<User>
}