package com.poc.kotlinpoc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("comment")
data class Comment (@Id val commentId: Int,
                    val messageId: Int,
                    val commentText: String)