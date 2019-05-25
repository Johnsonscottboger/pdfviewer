package com.aning.pdfviewer.service.impl

import com.aning.pdfviewer.dao.IDocumentDao
import com.aning.pdfviewer.entity.Document
import com.aning.pdfviewer.service.IDocumentService
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * 提供对 [Document] 实体操作的集合的默认实现
 */
@Service
public class DefaultDocumentService : IDocumentService {

    @Resource
    private lateinit var _documentDao: IDocumentDao;

    /**
     * 获取所有 [Document] 记录
     * @return 所有 [Document] 记录
     */
    public override fun getAll(): List<Document> {
        return this._documentDao.getAll();
    }

    /**
     * 根据 [id] 获取 [Document] 记录
     * @param id 指定的 id
     * @return [Document] 记录
     */
    public override fun getById(id: Long): Document? {
        return this._documentDao.getById(id);
    }

    /**
     * 添加 [Document] 记录
     * @param document 添加的 [Document] 实例
     */
    public override fun add(userId: Long, document: Document) {
        this._documentDao.add(document);
    }

    /**
     * 根据 [userId] 获取所有 [Document] 记录
     * @param userId 指定的 userId
     * @return [Document] 记录
     */
    public override fun getAllByUserId(userId: Long): List<Document> {
        return this._documentDao.getAllByUserId(userId)
    }
}