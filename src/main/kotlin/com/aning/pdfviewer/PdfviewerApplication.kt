package com.aning.pdfviewer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PdfviewerApplication

fun main(args: Array<String>) {
    runApplication<PdfviewerApplication>(*args)
}
