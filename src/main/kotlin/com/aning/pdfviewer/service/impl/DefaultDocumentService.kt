package com.aning.pdfviewer.service.impl

import com.aning.pdfviewer.dao.IDocumentDao
import com.aning.pdfviewer.dao.IUserDocumentDao
import com.aning.pdfviewer.entity.Document
import com.aning.pdfviewer.entity.UserDocument
import com.aning.pdfviewer.service.IDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * 提供对 [Document] 实体操作的集合的默认实现
 */
@Service
public class DefaultDocumentService : IDocumentService {

    @Resource
    private lateinit var _documentDao: IDocumentDao;

    @Resource
    private lateinit var _userDocumentDao: IUserDocumentDao;

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
        this._userDocumentDao.add(UserDocument(userId = userId, documentId = document.id));
    }

    /**
     * 根据 [userId] 获取所有 [Document] 记录
     * @param userId 指定的 userId
     * @return [Document] 记录
     */
    public override fun getAllByUserId(userId: Long): List<Document> {
        return this._userDocumentDao.getAllByUserId(userId)
    }

    /**
     * 删除 [Document] 记录
     * @param userId 删除记录的 [User.id]
     * @param document 删除的 [Document] 实例
     */
    override fun delete(userId: Long, document: Document) {
        //查找当前文档是否被至少一个用户引用
        //如果只有一个, 且为当前用户, 则删除文档.
        //否则只删除当前用户的引用
        val users = this._userDocumentDao.getAllByDocumentId(document.id)
        if (users.isEmpty()
                || (users.count() == 1 && users.first().id == userId)) {
            this._documentDao.delete(document)
        } else {
            this._userDocumentDao.delete(userId, document.id)
        }
    }
}