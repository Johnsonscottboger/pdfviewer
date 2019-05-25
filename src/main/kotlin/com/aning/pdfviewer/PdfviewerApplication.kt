package com.aning.pdfviewer

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan(basePackages = ["com.aning.pdfviewer.dao"])
class PdfviewerApplication

fun main(args: Array<String>) {
    runApplication<PdfviewerApplication>(*args)
}
