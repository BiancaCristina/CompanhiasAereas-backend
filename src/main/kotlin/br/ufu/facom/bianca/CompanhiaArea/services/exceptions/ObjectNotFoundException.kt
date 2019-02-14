package br.ufu.facom.bianca.CompanhiaArea.services.exceptions

import java.lang.RuntimeException

class ObjectNotFoundException(msg: String):
        RuntimeException(msg) {

    fun ObjectNotFoundException (msg: String, cause: Throwable) {
        return ObjectNotFoundException(msg, cause)
    }
}