package br.ufu.facom.bianca.CompanhiaArea.dto

import java.time.LocalDate

data class ManutencaoDTO (
        val id: Long,
        var data: LocalDate,
        var aeronaveDTO: AeronaveDTO
)