package com.mowagdy.superchat.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Contact(@Id @GeneratedValue var id: Long? = null,
                   var name: String = "",
                   var email: String = "")
