package br.ufu.facom.bianca.CompanhiaArea.repositories

import br.ufu.facom.bianca.CompanhiaArea.domain.Aeronave
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AeronaveRepository: CrudRepository<Aeronave, Long> {

}