package com.mowagdy.superchat.repository

import com.mowagdy.superchat.model.Contact
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ContactRepository : PanacheRepository<Contact>
