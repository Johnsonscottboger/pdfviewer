package com.aning.pdfviewer.entity

/**
 * 用户
 */
public data class User(
        var id: Long = 0,
        var name: String,
        var email: String,
        var password: String
)