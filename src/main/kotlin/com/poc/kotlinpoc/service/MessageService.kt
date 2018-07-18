package com.poc.kotlinpoc.service

import com.poc.kotlinpoc.entity.Message

interface MessageService {

    fun getAllMessages(): List<Message>

    fun getMessageByID(messageId: Int): Message

    fun createMessage(message: Message): Message

    fun updateMessage(messageId: Int, message: Message): Message

    fun deleteMessage(messageId: Int)

    fun getAllMessagesByAuthor(author: String): List<Message>

}