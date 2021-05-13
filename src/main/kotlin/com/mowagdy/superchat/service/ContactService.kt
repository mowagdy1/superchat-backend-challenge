package com.mowagdy.superchat.service

import com.mowagdy.superchat.dto.ContactCreationRequest
import com.mowagdy.superchat.dto.ContactListingResponse
import com.mowagdy.superchat.dto.ContactMessageSendingRequest

interface ContactService {

    fun list(): List<ContactListingResponse>

    fun create(request: ContactCreationRequest)

    fun sendMessageToContact(contactId: Long, request: ContactMessageSendingRequest)
}
