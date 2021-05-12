package com.mowagdy.superchat.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Entity

@Entity
data class Contact(var name: String = "",
                   var email: String = "") : PanacheEntity()
