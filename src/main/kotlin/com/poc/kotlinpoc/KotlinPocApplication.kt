package com.poc.kotlinpoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlinPocApplication

fun main(args: Array<String>) {
    runApplication<KotlinPocApplication>(*args)
}
