package br.ufu.facom.bianca.CompanhiaArea.dto

import javax.validation.constraints.NotEmpty

data class NewVooDTO (
        val id: Long,

        @NotEmpty(message= "Preenchimento obrigatório")
        var origem: String,

        @NotEmpty(message= "Preenchimento obrigatório")
        var destino: String
)