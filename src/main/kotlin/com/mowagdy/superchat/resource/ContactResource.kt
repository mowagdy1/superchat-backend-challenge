package com.mowagdy.superchat.resource

import com.mowagdy.superchat.dto.ContactCreationRequest
import com.mowagdy.superchat.dto.ContactListingResponse
import com.mowagdy.superchat.dto.ContactMessageSendingRequest
import com.mowagdy.superchat.service.ContactService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ContactResource {
    @Inject
    internal lateinit var contactService: ContactService

    @GET
    fun listContacts(): List<ContactListingResponse> {
        return contactService.list()
    }

    @POST
    fun createContact(request: ContactCreationRequest) {
        contactService.create(request)
    }

    @POST
    @Path("/{id}/messages")
    fun sendMessageToContact(@PathParam("id") id: Long, request: ContactMessageSendingRequest) {
        contactService.sendMessageToContact(id, request)
    }

}
