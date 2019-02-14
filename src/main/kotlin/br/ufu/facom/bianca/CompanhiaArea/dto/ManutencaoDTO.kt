package br.ufu.facom.bianca.CompanhiaArea.dto

import br.ufu.facom.bianca.CompanhiaArea.domain.Mecanico
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ManutencaoDTO (
        var id: Long,
        var dataString: String,
        var aeronaveDTO: AeronaveDTO,
        var mecanicosDTO: MutableSet<Mecanico> = HashSet()
) {
    var data: LocalDate

    init {
        var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        this.data = LocalDate.parse(dataString, formato)

    }
}