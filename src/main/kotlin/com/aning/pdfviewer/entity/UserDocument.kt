package com.aning.pdfviewer.entity

/**
 * 用户 -文档 关联表
 */
public data class UserDocument(
        var id: Long = 0,
        var userId: Long,
        var documentId: Long
)