package br.ufu.facom.bianca.CompanhiaArea.dto

import javax.validation.constraints.NotEmpty

data class AeronaveDTO (
        var id: Long,

        @NotEmpty(message= "Preenchimento obrigatório")
        var nome: String
)