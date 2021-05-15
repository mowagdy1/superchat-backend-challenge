package com.mowagdy.superchat.provider

import io.vertx.core.http.HttpServerRequest
import org.jboss.logging.Logger
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo
import javax.ws.rs.ext.Provider

@Provider
class LoggingFilter : ContainerRequestFilter {
    @Context
    var info: UriInfo? = null
    @Context
    var request: HttpServerRequest? = null

    companion object {
        private val LOG = Logger.getLogger(LoggingFilter::class.java)
    }

    override fun filter(context: ContainerRequestContext) {
        val method = context.method
        val path = info!!.path
        val address = request!!.remoteAddress().toString()
        LOG.infof("Request %s %s from IP %s", method, path, address)
    }
}
