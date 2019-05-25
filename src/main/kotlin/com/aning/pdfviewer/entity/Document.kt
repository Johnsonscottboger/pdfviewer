package com.aning.pdfviewer.entity

/**
 * 文档
 */
public data class Document(
        var id: Long = 0,
        var md5: String,
        var name: String,
        var size: Long,
        var type: String
)