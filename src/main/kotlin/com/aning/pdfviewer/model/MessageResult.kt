package com.aning.pdfviewer.model


/**
 * 表示结果信息
 */
public class MessageResult(
        /**
         * 操作是否成功
         */
        public val success: Boolean,


        /**
         * 操作结果信息
         */
        public val message: String,
        /**
         * 操作结果代码
         */
        public val code: Int = 0
)