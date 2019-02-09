package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Piloto
import br.ufu.facom.bianca.CompanhiaArea.repositories.PilotoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PilotoService {

    @Autowired
    private lateinit var repo: PilotoRepository

    fun findById (id: Long): Piloto {
        var obj = repo.findById(id).orElse(null);

        return obj;
    }
}