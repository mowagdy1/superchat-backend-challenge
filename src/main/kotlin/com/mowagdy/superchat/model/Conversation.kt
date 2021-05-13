package com.mowagdy.superchat.model

import javax.persistence.*

@Entity
data class Conversation(@Id @GeneratedValue var id: Long? = null,
//                        @OneToMany(mappedBy = "conversation") var messages: List<Message> = listOf(),
                        @OneToOne @JoinColumn(name = "contactId") var contact: Contact = Contact())
