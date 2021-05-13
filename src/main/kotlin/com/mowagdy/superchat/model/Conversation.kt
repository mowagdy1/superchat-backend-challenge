package com.mowagdy.superchat.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Conversation(@Id @GeneratedValue var id: Long? = null,
//                        @OneToMany(mappedBy = "conversation") var messages: List<Message> = listOf(),
                        var contactId: Long = 0L)
