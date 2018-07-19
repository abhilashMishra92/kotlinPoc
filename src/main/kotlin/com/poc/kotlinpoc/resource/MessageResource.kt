package com.poc.kotlinpoc.resource

import com.poc.kotlinpoc.entity.Message
import com.poc.kotlinpoc.service.MessageService
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageResource (var messageService: MessageService) {

    @GetMapping
    fun getMessages() = createLinks(messageService.getAllMessages())

    @GetMapping(value = "/{messageId}")
    fun getMessageByID(@PathVariable messageId: Int) = createLinks(messageService.getMessageByID(messageId))

    @PostMapping
    fun createMessage(@RequestBody message:Message) = createLinks(messageService.createMessage(message))

    @PutMapping(value = "/{messageId}")
    fun updateMessage(@PathVariable messageId: Int,
                      @RequestBody message:Message) = createLinks(messageService.updateMessage(messageId, message))

    @DeleteMapping(value = "/{messageId}")
    fun deleteMessage(@PathVariable messageId: Int) = messageService.deleteMessage(messageId)

    @GetMapping(value = "/author/{author}")
    fun getMessagesByAuthor(@PathVariable author: String) = createLinks(messageService.getAllMessagesByAuthor(author))


    private fun createLinks (message: Message): Message {
        val selfLink = linkTo(methodOn(MessageResource::class.java).getMessageByID(message.messageId))
                .withSelfRel().withType("GET")
        val commentLink = linkTo(methodOn(CommentResource::class.java).getAllComments(message.messageId))
                .withRel("comments").withType("GET")
        message.add(selfLink)
        message.add(commentLink)
        return message
    }

    private fun createLinks (list: List<Message>): List<Message> {
        for (message in list) {
            createLinks(message)
        }
        return list
    }
}