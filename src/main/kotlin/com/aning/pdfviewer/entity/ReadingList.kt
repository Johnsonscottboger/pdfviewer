package com.aning.pdfviewer.entity

import java.time.LocalDateTime

/**
 * 阅读列表
 */
public data class ReadingList(
        var id: Long,
        var userId: Long,
        var documentId: Long,
        var lastedReadDateTime: LocalDateTime,
        var lastedReadPosition: Int
)