package com.mowagdy.superchat.resource

import com.mowagdy.superchat.dto.ConversationListingResponse
import com.mowagdy.superchat.service.ConversationService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/conversations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ConversationResource {
    @Inject
    internal lateinit var conversationService: ConversationService

    @GET
    fun listConversations(): List<ConversationListingResponse> {
        return conversationService.list()
    }

}
