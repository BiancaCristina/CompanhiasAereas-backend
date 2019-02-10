package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Certificado
import br.ufu.facom.bianca.CompanhiaArea.repositories.CertificadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CertificadoService {

    @Autowired
    private lateinit var repo: CertificadoRepository

    fun findById (id: Long): Certificado {
        var obj = repo.findById(id).orElse(null);

        return obj;
    }
}