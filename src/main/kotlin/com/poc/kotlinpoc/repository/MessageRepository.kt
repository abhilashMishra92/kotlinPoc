package com.poc.kotlinpoc.repository

import com.poc.kotlinpoc.entity.Message
import org.springframework.data.mongodb.repository.MongoRepository

interface MessageRepository : MongoRepository <Message, Int> {

    fun findByAuthorAllIgnoreCase(author: String) : List<Message>

}