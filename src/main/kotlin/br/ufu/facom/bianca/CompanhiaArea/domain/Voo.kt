package br.ufu.facom.bianca.CompanhiaArea.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Voo (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long

        //var origem:
        //var destino:
        //var aeronave
) {
    var distancia: Number = 0
    var preco: Number = 0
    var partidaPrevista: LocalDateTime ? = null
    var chegadaPrevista: LocalDateTime ? = null
    //var status
}