package com.poc.kotlinpoc.resource

import com.poc.kotlinpoc.entity.Comment
import com.poc.kotlinpoc.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages/{messageId}/comments")
class CommentResource (var commentService: CommentService) {

    @GetMapping
    fun getAllComments(@PathVariable messageId: Int) = commentService.getAllCommentsForMessage(messageId)

    @GetMapping("/{commentId}")
    fun getComments(@PathVariable messageId: Int, @PathVariable commentId: Int) = commentService.getCommentById(messageId, commentId)

    @PostMapping
    fun createComment(@PathVariable messageId: Int,
                      @RequestBody comment: Comment) = commentService.createComment(messageId, comment)

    @PutMapping("/{commentId}")
    fun updateComment(@PathVariable messageId: Int,
                      @PathVariable commentId: Int,
                      @RequestBody comment: Comment) = commentService.updateComment(messageId,commentId,comment)

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable messageId: Int,
                      @PathVariable commentId: Int) = commentService.deleteComment(messageId, commentId)
}