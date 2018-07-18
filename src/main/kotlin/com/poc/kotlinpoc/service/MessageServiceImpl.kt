package com.poc.kotlinpoc.service

import com.poc.kotlinpoc.entity.Message
import com.poc.kotlinpoc.repository.MessageRepository
import org.springframework.stereotype.Service

@Service("messageService")
class MessageServiceImpl (var messageRepository: MessageRepository): MessageService {

    override fun getAllMessages(): List<Message> {
        return messageRepository.findAll()
    }

    override fun getMessageByID(messageId: Int): Message {
        return messageRepository.findById(messageId).orElseThrow({Exception("message Id not found")})
    }

    override fun createMessage(message: Message): Message {
        if (messageRepository.existsById(message.messageId)) {
            throw Exception("Message ID already exists")
        }
        return messageRepository.save(message)
    }

    override fun updateMessage(messageId: Int, message: Message): Message {
        if (message.messageId != messageId) {
            throw Exception("Message ID does not match")
        }
        if (!messageRepository.existsById(message.messageId)) {
            throw Exception("Message ID does not exists")
        }
        return messageRepository.save(message)
    }

    override fun deleteMessage(messageId: Int) {
        messageRepository.deleteById(messageId)
    }

    override fun getAllMessagesByAuthor(author: String): List<Message> {
        return messageRepository.findByAuthorAllIgnoreCase(author)
    }
}