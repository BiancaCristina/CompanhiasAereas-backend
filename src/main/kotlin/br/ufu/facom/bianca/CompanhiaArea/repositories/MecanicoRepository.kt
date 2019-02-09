package br.ufu.facom.bianca.CompanhiaArea.repositories

import br.ufu.facom.bianca.CompanhiaArea.domain.Mecanico
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MecanicoRepository: CrudRepository<Mecanico, Long> {

}