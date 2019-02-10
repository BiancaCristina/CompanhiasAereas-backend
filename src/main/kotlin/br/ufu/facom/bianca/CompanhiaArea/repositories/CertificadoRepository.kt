package br.ufu.facom.bianca.CompanhiaArea.repositories

import br.ufu.facom.bianca.CompanhiaArea.domain.Certificado
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CertificadoRepository: CrudRepository<Certificado, Long> {

}