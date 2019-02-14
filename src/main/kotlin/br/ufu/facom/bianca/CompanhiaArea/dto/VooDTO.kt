package br.ufu.facom.bianca.CompanhiaArea.dto

import br.ufu.facom.bianca.CompanhiaArea.domain.enums.StatusVoo
import java.time.LocalDateTime

data class VooDTO (
        val id: Long,
        var distancia: Number ?= null,
        var preco: Number ?= null,
        var partidaPrevista: LocalDateTime? = null,
        var chegadaPrevista: LocalDateTime? = null,
        var status: StatusVoo?= null
        )

// Classe utilizada para dar update em Voos
// Destino e origem não podem ser alterados em updates