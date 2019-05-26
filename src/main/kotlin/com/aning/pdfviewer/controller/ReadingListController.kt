package com.aning.pdfviewer.controller

import com.aning.pdfviewer.entity.ReadingList
import com.aning.pdfviewer.model.ResultMessage
import com.aning.pdfviewer.service.IReadingListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime

@RestController
@RequestMapping("/reading")
public class ReadingListController {

    @Autowired
    private lateinit var _readingListService: IReadingListService

    /**
     * 根据 [userId] 获取所有 [ReadingList] 记录
     * @param userId 指定的用户 id
     * @return [ReadingList] 记录
     */
    @GetMapping("/{userId}")
    public fun getAllByUserId(@PathVariable("userId") userId: Long): List<ReadingList> {
        return this._readingListService.getAllByUserId(userId)
    }

    /**
     * 添加 [ReadingList] 记录
     * @param userId 指定的用户 id
     * @param documentId 指定的文档 id
     */
    @PostMapping("/add")
    public fun add(userId: Long, documentId: Long) {
        this._readingListService.add(ReadingList(
                userId = userId,
                documentId = documentId,
                lastedReadDateTime = LocalDateTime.now(),
                lastedReadPosition = 0)
        )
    }

    /**
     * 移除 [ReadingList] 记录
     * @param readingListId 指定要移除的 id
     */
    @PostMapping("/remove/{readingListId}")
    public fun remove(@PathVariable("readingListId") readingListId: Long): ResultMessage {
        val item = this._readingListService.getById(readingListId)
        if (item != null) {
            this._readingListService.remove(item)
        }
        return ResultMessage(true, "移除成功")
    }

    /**
     * 更新阅读进度
     * @param readingListId 指定的记录 id
     * @param lastReadPosition 指定的阅读位置
     */
    @PostMapping("update/")
    public fun updateProgress(readingListId: Long, lastReadPosition: Int): ResultMessage {
        val item = this._readingListService.getById(readingListId)
        return if (item != null) {
            item.lastedReadDateTime = LocalDateTime.now()
            item.lastedReadPosition = lastReadPosition
            this._readingListService.updateProgress(item)
            return ResultMessage(true, "更新成功")
        } else {
            ResultMessage(false, "记录不存在")
        }
    }
}