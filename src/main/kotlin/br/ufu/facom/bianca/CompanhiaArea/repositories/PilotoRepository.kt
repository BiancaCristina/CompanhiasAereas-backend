package br.ufu.facom.bianca.CompanhiaArea.repositories

import br.ufu.facom.bianca.CompanhiaArea.domain.Piloto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PilotoRepository: CrudRepository<Piloto, Long> {

}