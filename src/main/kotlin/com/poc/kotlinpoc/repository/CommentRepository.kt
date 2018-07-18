package com.poc.kotlinpoc.repository

import com.poc.kotlinpoc.entity.Comment
import org.springframework.data.mongodb.repository.MongoRepository

interface CommentRepository : MongoRepository <Comment,Int> {

    fun findCommentsByMessageId(messageId: Int) : List<Comment>

    fun findCommentByMessageIdAndCommentId(messageId: Int, commentId: Int): Comment

    fun deleteByMessageIdAndCommentId(messageId: Int, commentId: Int)
}