package br.ufu.facom.bianca.CompanhiaArea.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Aeronave (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var nome: String,
        var distanciaLimite: Number
) {
    // var manuntencoes
    // voos realizados
}