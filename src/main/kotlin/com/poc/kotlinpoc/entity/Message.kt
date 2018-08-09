package com.poc.kotlinpoc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.hateoas.ResourceSupport

@TypeAlias("message")
open class Message (@Id val messageId: Int,
                    val text: String,
                    val author: String,
                    val contributors: List<User>?) : ResourceSupport() {
    override fun toString(): String {
        return "Message(messageId=$messageId, text='$text', author='$author', contributors=$contributors)"
    }
}
