package com.poc.kotlinpoc.service

import com.poc.kotlinpoc.entity.Comment
import com.poc.kotlinpoc.repository.CommentRepository
import org.springframework.stereotype.Service

@Service("commentService")
class CommentServiceImpl (var commentRepository: CommentRepository): CommentService {

    override fun getAllCommentsForMessage(messageId: Int): List<Comment> {
        return commentRepository.findCommentsByMessageId(messageId)
    }

    override fun getCommentById(messageId: Int, commentId: Int): Comment {
        return commentRepository.findCommentByMessageIdAndCommentId(messageId, commentId)
    }

    override fun createComment(messageId: Int, comment: Comment): Comment {
        if (comment.messageId != messageId) {
            throw Exception("message ID does not match")
        }
        if (commentRepository.existsById(comment.commentId)) {
            throw Exception("comment ID already exist")
        }
        return commentRepository.save(comment)
    }

    override fun updateComment(messageId: Int, commentId: Int, comment: Comment): Comment {
        if (comment.messageId != messageId) {
            throw Exception("message ID does not match")
        }
        if (!commentRepository.existsById(comment.commentId)) {
            throw Exception("comment ID does not exist")
        }
        return commentRepository.save(comment)
    }

    override fun deleteComment(messageId: Int, commentId: Int) {
        return commentRepository.deleteByMessageIdAndCommentId(messageId, commentId)
    }
}