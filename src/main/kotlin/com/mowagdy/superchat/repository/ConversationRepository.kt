package com.mowagdy.superchat.repository

import com.mowagdy.superchat.model.Conversation
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ConversationRepository : PanacheRepository<Conversation> {
//    fun findByFirstNameAndLastName(firstName: String, lastName: String): List<Employee> =
//            list("firstName = ?1 and lastName = ?2", firstName, lastName)


    fun findByContactId(contactId: Long) = find("contactId", contactId).firstResult()

}
