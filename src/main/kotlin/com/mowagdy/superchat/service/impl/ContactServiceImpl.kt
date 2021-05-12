package com.mowagdy.superchat.service.impl

import com.mowagdy.superchat.dto.ContactRequest
import com.mowagdy.superchat.dto.ContactResponse
import com.mowagdy.superchat.model.Contact
import com.mowagdy.superchat.repository.ContactRepository
import com.mowagdy.superchat.service.ContactService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class ContactServiceImpl : ContactService {

    @Inject
    internal lateinit var contactRepository: ContactRepository

    override fun list(): List<ContactResponse> {
        return contactRepository.listAll().map { ContactResponse(it.id, it.name, it.email) }
    }

    @Transactional
    override fun create(request: ContactRequest) {
        contactRepository.persist(Contact(name = request.name, email = request.email))
    }

}
