package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Manutencao
import br.ufu.facom.bianca.CompanhiaArea.repositories.ManutencaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ManutencaoService {

    @Autowired
    private lateinit var repo: ManutencaoRepository

    fun findById (id: Long): Manutencao {
        var obj = repo.findById(id).orElse(null);

        return obj;
    }
}