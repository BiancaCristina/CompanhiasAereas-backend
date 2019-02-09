package br.ufu.facom.bianca.CompanhiaArea.repositories

import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VooRepository: CrudRepository<Voo, Long> {

}