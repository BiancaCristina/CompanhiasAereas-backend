package br.ufu.facom.bianca.CompanhiaArea.services.exceptions

import java.lang.RuntimeException

class DataIntegrityException(msg: String):
        RuntimeException(msg) {

    fun DataIntegrityException(msg: String, cause: Throwable) {
        return DataIntegrityException(msg, cause)
    }
}