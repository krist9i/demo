package com.example.demo.utils.utils

import com.example.demo.utils.exceptions.SerializationException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch

/**
 * USAGE IN UPDATE FUNCTION
 * -- in update-request can be filled just the necessary data (for update)
 * -- other parameters stay the same as in previous entity
 **/
inline fun <reified T: Any> mergePatch(t: T, patch: JsonNode, clazz: Class<T>?): T {
    val mapper = ObjectMapper().registerModule(ParameterNamesModule())
            .registerModule(Jdk8Module())
            .registerModule(JavaTimeModule())
            .findAndRegisterModules()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    var node: JsonNode = mapper.convertValue(t, JsonNode::class.java)
    val mergePatch = JsonMergePatch.fromJson(patch)

    node = mergePatch.apply(node)
    return try {
        mapper.treeToValue(node, clazz)
    } catch (e: Exception) {
        throw SerializationException("There was an error during serialization request: $e")
    }
}