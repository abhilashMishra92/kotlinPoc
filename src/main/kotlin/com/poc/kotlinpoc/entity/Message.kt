package com.poc.kotlinpoc.entity

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.hateoas.ResourceSupport

@TypeAlias("message")
open class Message (@Id val messageId: Int,
                    val text: String,
                    val author: String) : ResourceSupport()
