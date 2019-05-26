package com.aning.pdfviewer.service.impl

import com.aning.pdfviewer.dao.IReadingListDao
import com.aning.pdfviewer.entity.ReadingList
import com.aning.pdfviewer.service.IReadingListService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.annotation.Resource

/**
 * 提供对 [ReadingList] 实体操作的集合的默认实现
 */
@Service
public class DefaultReadingListService : IReadingListService {

    @Resource
    private lateinit var _readingListDao: IReadingListDao;

    /**
     * 添加 [ReadingList] 记录
     * @param readingList 添加的 [ReadingList] 记录
     */
    override fun add(readingList: ReadingList) {
        this._readingListDao.add(readingList)
    }

    /**
     * 移除 [ReadingList] 记录
     * @param readingList 移除 [ReadingList] 记录
     */
    override fun remove(readingList: ReadingList) {
        this._readingListDao.delete(readingList)
    }

    /**
     * 根据 [id] 获取 [ReadingList] 记录
     * @return [ReadingList] 记录
     */
    override fun getById(id: Long): ReadingList? {
        return this._readingListDao.getById(id)
    }

    /**
     * 根据 [userId] 获取所有 [ReadingList] 记录
     * @return [ReadingList] 记录
     */
    override fun getAllByUserId(userId: Long): List<ReadingList> {
        return this._readingListDao.getAllByUserId(userId)
    }

    /**
     * 更新阅读进度
     * @param readingList [ReadingList] 记录
     */
    override fun updateProgress(readingList: ReadingList) {
        return this._readingListDao.update(readingList)
    }
}