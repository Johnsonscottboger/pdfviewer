package com.aning.pdfviewer.service

import com.aning.pdfviewer.entity.ReadingList
import java.time.LocalDateTime

/**
 * 提供对 [ReadingList] 实体操作的集合
 */
public interface IReadingListService {

    /**
     * 添加 [ReadingList] 记录
     * @param readingList 添加的 [ReadingList] 记录
     */
    public fun add(readingList: ReadingList);

    /**
     * 移除 [ReadingList] 记录
     * @param readingList 移除 [ReadingList] 记录
     */
    public fun remove(readingList: ReadingList);

    /**
     * 根据 [id] 获取 [ReadingList] 记录
     * @return [ReadingList] 记录
     */
    public fun getById(id: Long): ReadingList?;

    /**
     * 根据 [userId] 获取所有 [ReadingList] 记录
     * @param userId 指定的用户 id
     * @return [ReadingList] 记录
     */
    public fun getAllByUserId(userId: Long): List<ReadingList>;

    /**
     * 更新阅读进度
     * @param readingList [ReadingList] 记录
     */
    public fun updateProgress(readingList: ReadingList)
}