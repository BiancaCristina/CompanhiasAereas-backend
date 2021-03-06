package br.ufu.facom.bianca.CompanhiaArea.dto

import javax.validation.constraints.NotEmpty

data class PilotoDTO (
    var id: Long,

    @NotEmpty(message= "Preenchimento obrigatório")
    var nome: String,

    @NotEmpty(message= "Preenchimento obrigatório")
    var cpf: String
)