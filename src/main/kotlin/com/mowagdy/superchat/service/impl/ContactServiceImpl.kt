package com.mowagdy.superchat.service.impl

import com.mowagdy.superchat.dto.ContactCreationRequest
import com.mowagdy.superchat.dto.ContactListingResponse
import com.mowagdy.superchat.dto.ContactMessageSendingRequest
import com.mowagdy.superchat.dto.ExternalMessageSendingRequest
import com.mowagdy.superchat.exception.EntityNotFoundException
import com.mowagdy.superchat.model.Contact
import com.mowagdy.superchat.model.Conversation
import com.mowagdy.superchat.model.Message
import com.mowagdy.superchat.model.MessageAuthor
import com.mowagdy.superchat.repository.ContactRepository
import com.mowagdy.superchat.repository.ConversationRepository
import com.mowagdy.superchat.repository.MessageRepository
import com.mowagdy.superchat.service.ContactService
import com.mowagdy.superchat.service.ExternalMessageService
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class ContactServiceImpl : ContactService {

    @Inject
    internal lateinit var contactRepository: ContactRepository
    @Inject
    internal lateinit var conversationRepository: ConversationRepository
    @Inject
    internal lateinit var messageRepository: MessageRepository
    @Inject
    @RestClient
    internal lateinit var externalMessageService: ExternalMessageService


    override fun list(): List<ContactListingResponse> {
        return contactRepository.listAll().map { ContactListingResponse(it.id!!, it.name, it.email) }
    }

    @Transactional
    override fun create(request: ContactCreationRequest) {
        contactRepository.persist(Contact(name = request.name, email = request.email))
    }

    @Transactional
    override fun sendMessageToContact(contactId: Long, request: ContactMessageSendingRequest) {

        val contact = contactRepository.findById(contactId)
                ?: throw EntityNotFoundException("Contact [$contactId] not found.")

        val conversation: Conversation = conversationRepository.findByContactId(contactId)
                ?: createConversation(contact)

        val message = Message(conversationId = conversation.id!!, content = request.content, author = MessageAuthor.COMPANY)
        messageRepository.persist(message)

        externalMessageService.send(ExternalMessageSendingRequest(email = contact.email, message = message.content))
    }

    private fun createConversation(contact: Contact): Conversation {
        val conversation = Conversation(contact = contact)
        conversationRepository.persist(conversation)
        return conversation
    }

}
