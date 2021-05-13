package com.mowagdy.superchat.service

import com.mowagdy.superchat.dto.ExternalMessageSendingRequest
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.POST
import javax.ws.rs.Produces

@RegisterRestClient
interface ExternalMessageService {

    @POST
    @Produces("application/json")
    fun send(payload: ExternalMessageSendingRequest)
}
