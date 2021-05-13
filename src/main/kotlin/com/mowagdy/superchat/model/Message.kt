package com.mowagdy.superchat.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Message(@Id @GeneratedValue var id: Long? = null,
                   var conversationId: Long = 0L,
//                   @ManyToOne @JoinColumn(name = "conversationId") var conversation: Conversation = Conversation(),
                   var content: String = "",
                   var author: MessageAuthor = MessageAuthor.NONE)

enum class MessageAuthor {
    NONE,
    CONTACT,
    COMPANY,
}
