package br.ufu.facom.bianca.CompanhiaArea.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Voo (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var origem: String,
        var destino: String,
        var distancia: Number,
        var preco: Number,
        var partidaPrevista: LocalDateTime ? = null,
        var chegadaPrevista: LocalDateTime ? = null
) {
        @ManyToOne
        @JoinColumn(name="aeronave_id")
        lateinit var aeronave: Aeronave

}