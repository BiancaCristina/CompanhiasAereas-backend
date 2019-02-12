package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Voo (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        var origem: String,
        var destino: String,
        var distancia: Number ?= null,
        var preco: Number ?= null,
        var partidaPrevista: LocalDateTime ? = null,
        var chegadaPrevista: LocalDateTime ? = null
) {
        @ManyToOne
        @JoinColumn(name="aeronave_id")
        var aeronave: Aeronave ?= null

}