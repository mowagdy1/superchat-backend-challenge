package com.mowagdy.superchat.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode

object ObjectMappingUtil {

    private val objectMapper = ObjectMapper()

    fun toJsonPair(key: String, value: String): ObjectNode =
            objectMapper.createObjectNode().put(key, value)

    fun toJsonNode(json: String): JsonNode =
            objectMapper.readTree(json)
}
