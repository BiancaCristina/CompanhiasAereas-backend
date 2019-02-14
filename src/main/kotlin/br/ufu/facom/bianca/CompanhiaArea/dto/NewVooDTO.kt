package br.ufu.facom.bianca.CompanhiaArea.dto

import br.ufu.facom.bianca.CompanhiaArea.domain.enums.StatusVoo
import javax.validation.constraints.NotEmpty

data class NewVooDTO (
        val id: Long,

        @NotEmpty(message= "Preenchimento obrigatório")
        var origem: String,

        @NotEmpty(message= "Preenchimento obrigatório")
        var destino: String,

        var status: StatusVoo?= null
) {
        init {
                // Todo status inicializa como previsto
                this.status = StatusVoo.PREVISTO
        }
}