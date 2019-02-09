package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Mecanico
import br.ufu.facom.bianca.CompanhiaArea.repositories.MecanicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MecanicoService {

    @Autowired
    private lateinit var repo: MecanicoRepository

    fun findById (id: Long): Mecanico {
        var obj = repo.findById(id).orElse(null);

        return obj;
    }
}