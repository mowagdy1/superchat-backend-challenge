package com.mowagdy.superchat.service

import com.mowagdy.superchat.dto.ContactRequest
import com.mowagdy.superchat.dto.ContactResponse

interface ContactService {

    fun list(): List<ContactResponse>

    fun create(request: ContactRequest)
}
