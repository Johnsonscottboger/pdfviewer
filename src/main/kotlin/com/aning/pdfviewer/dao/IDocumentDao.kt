package com.aning.pdfviewer.dao

import com.aning.pdfviewer.entity.Document
import org.apache.ibatis.annotations.Param

/**
 *  提供对 [Document] 实体操作的方法集合
 */
public interface IDocumentDao {

    /**
     * 添加 [Document] 记录
     * @param document 添加的 [Document] 实例
     */
    public fun add(document: Document);

    /**
     * 删除 [Document] 记录
     * @param document 删除的 [Document] 实例
     */
    public fun delete(document: Document);

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
     * 根据 [md5] 获取 [Document] 记录
     * @param md5 指定的 md5
     * @return [Document] 记录
     */
    public fun getByMD5(md5: String): Document?;

    /**
     * 根据 [userId] 获取所有 [Document] 记录
     * @param userId 指定的 userId
     * @return [Document] 记录
     */
    public fun getAllByUserId(userId: Long): List<Document>;
}