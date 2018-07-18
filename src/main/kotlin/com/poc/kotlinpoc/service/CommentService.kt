package com.poc.kotlinpoc.service

import com.poc.kotlinpoc.entity.Comment

interface CommentService {

    fun getAllCommentsForMessage(messageId: Int): List<Comment>

    fun getCommentById(messageId: Int, commentId: Int): Comment

    fun createComment(messageId: Int, comment: Comment): Comment

    fun updateComment(messageId: Int, commentId: Int, comment: Comment): Comment

    fun deleteComment(messageId: Int, commentId: Int)
}