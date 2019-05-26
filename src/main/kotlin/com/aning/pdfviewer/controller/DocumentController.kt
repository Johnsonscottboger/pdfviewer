package com.aning.pdfviewer.controller

import com.aning.pdfviewer.entity.Document
import com.aning.pdfviewer.model.ResultMessage
import com.aning.pdfviewer.service.IDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 文档管理控制器
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private lateinit var _documentService: IDocumentService

    /**
     * 获取所有文档
     * @return 所有文档记录
     */
    @GetMapping("/")
    public fun getAll(): List<Document> {
        return this._documentService.getAll()
    }

    /**
     * 根据 [id] 获取文档
     * @return [Document] 记录
     */
    @GetMapping("/{id}")
    public fun getById(@PathVariable("id") id: Long): Document? {
        return this._documentService.getById(id)
    }

    /**
     * 添加新的文档
     * @param document 添加的 [Document] 实例
     * @return 结果信息
     */
    @PostMapping("/add")
    public fun add(userId: Long, @RequestBody document: Document): ResultMessage {
        return try {
            this._documentService.add(userId, document)
            ResultMessage(true, "添加成功")
        } catch (ex: Exception) {
            ResultMessage(false, "添加失败")
        }
    }

    /**
     * 删除用户文档
     * @param userId 删除的用户 id
     * @param document 删除的 [Document] 实例
     * @return 结果信息
     */
    public fun delete(userId: Long, @RequestBody document: Document): ResultMessage {
        return try {
            this._documentService.delete(userId, document)
            ResultMessage(true, "删除成功")
        } catch (ex: Exception) {
            ResultMessage(false, "删除失败")
        }
    }
}