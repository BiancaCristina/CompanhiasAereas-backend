package br.ufu.facom.bianca.CompanhiaArea.dto

import br.ufu.facom.bianca.CompanhiaArea.domain.Aeronave

data class CertificadoDTO (
        val id: Long,
        var aeronaveDTO: AeronaveDTO
)