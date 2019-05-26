package com.aning.pdfviewer.service

import com.aning.pdfviewer.entity.Document
import com.aning.pdfviewer.entity.User

/**
 * 提供对 [Document] 实体操作的集合
 */
public interface IDocumentService {

    /**
     * 添加 [Document] 记录
     * @param userId 添加记录的 [User.id]
     * @param document 添加的 [Document] 实例
     */
    public fun add(userId: Long, document: Document);

    /**
     * 删除 [Document] 记录
     * @param userId 删除记录的 [User.id]
     * @param document 删除的 [Document] 实例
     */
    public fun delete(userId: Long, document: Document);

    /**
     * 获取所有 [Document] 记录
     * @return 所有 [Document] 记录
     */
    public fun getAll(): List<Document>;

    /**
     * 根据 [id] 获取 [Document] 记录
     * @param id 指定的 id
     * @return [Document] 记录
     */
    public fun getById(id: Long): Document?;

    /**
     * 根据 [userId] 获取所有 [Document] 记录
     * @param userId 指定的 userId
     * @return [Document] 记录
     */
    public fun getAllByUserId(userId: Long): List<Document>;
}