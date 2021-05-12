package com.mowagdy.superchat.resource

import com.mowagdy.superchat.dto.ContactRequest
import com.mowagdy.superchat.dto.ContactResponse
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
    fun listContacts(): List<ContactResponse> {
        return contactService.list()
    }

    @POST
    fun createBrand(request: ContactRequest) {
        contactService.create(request)
    }
}
