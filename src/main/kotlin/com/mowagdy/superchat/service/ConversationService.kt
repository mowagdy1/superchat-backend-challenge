package com.mowagdy.superchat.service

import com.mowagdy.superchat.dto.ConversationListingResponse

interface ConversationService {

    fun list(): List<ConversationListingResponse>
}
