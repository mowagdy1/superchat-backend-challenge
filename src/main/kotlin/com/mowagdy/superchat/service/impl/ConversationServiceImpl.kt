package com.mowagdy.superchat.service.impl

import com.mowagdy.superchat.dto.ConversationListingResponse
import com.mowagdy.superchat.repository.ConversationRepository
import com.mowagdy.superchat.service.ConversationService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class ConversationServiceImpl : ConversationService {

    @Inject
    internal lateinit var conversationRepository: ConversationRepository

    override fun list(): List<ConversationListingResponse> {
        return conversationRepository.listAll().map { ConversationListingResponse(it.id!!, it.contact.id!!, it.contact.name) }
    }

}
