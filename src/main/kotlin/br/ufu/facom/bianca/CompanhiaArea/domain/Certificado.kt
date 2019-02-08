package br.ufu.facom.bianca.CompanhiaArea.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Certificado (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long
        // Piloto
        // Aeronave
        // Nota
) {
    // Data que foi tirada e data que expira
}