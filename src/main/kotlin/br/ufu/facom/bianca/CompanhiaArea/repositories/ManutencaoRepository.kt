package br.ufu.facom.bianca.CompanhiaArea.repositories

import br.ufu.facom.bianca.CompanhiaArea.domain.Manutencao
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ManutencaoRepository: CrudRepository<Manutencao, Long> {

}