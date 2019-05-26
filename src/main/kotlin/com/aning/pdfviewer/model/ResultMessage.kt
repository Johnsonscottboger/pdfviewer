package com.aning.pdfviewer.model


/**
 * 表示结果信息
 */
public open class ResultMessage(
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

/**
 * 表示带有值的结果
 */
public class ValueResultMessage<out T>(
        success: Boolean,
        message: String = "",
        code: Int = 0,

        /**
         * 操作结果值
         */
        public val value: T) : ResultMessage(success, message, code)