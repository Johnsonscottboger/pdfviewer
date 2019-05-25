package com.aning.pdfviewer.dao

import com.aning.pdfviewer.entity.ReadingList

/**
 *  提供对 [ReadingList] 实体操作的方法集合
 */
public interface IReadingListDao {

    /**
     * 添加 [ReadingList] 记录
     * @param readingList 添加的 [ReadingList] 记录
     */
    public fun add(readingList: ReadingList);

    /**
     * 删除 [ReadingList] 记录
     * @param readingList 删除的 [ReadingList] 记录
     */
    public fun delete(readingList: ReadingList);

    /**
     * 获取所有 [ReadingList] 记录
     * @return 所有 [ReadingList] 记录
     */
    public fun getAll(): List<ReadingList>

    /**
     * 根据 [id] 获取 [ReadingList] 记录
     * @return [ReadingList] 记录
     */
    public fun getById(id: Long): ReadingList?;

    /**
     * 根据 [userId] 获取所有 [ReadingList] 记录
     * @return [ReadingList] 记录
     */
    public fun getAllByUserId(userId: Long): List<ReadingList>;

    /**
     * 根据 [documentId] 获取所有 [ReadingList] 记录
     * @return [ReadingList] 记录
     */
    public fun getAllByDocumentId(documentId: Long): List<ReadingList>;

    /**
     * 修改 [ReadingList] 记录
     * @param readingList 指定修改的记录
     */
    public fun update(readingList: ReadingList);
}