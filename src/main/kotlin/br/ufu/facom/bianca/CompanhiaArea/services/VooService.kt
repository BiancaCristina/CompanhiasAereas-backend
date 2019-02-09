package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.repositories.VooRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class VooService {

    @Autowired
    private lateinit var repo: VooRepository

    fun findById (id: Long): Voo {
        var obj = repo.findById(id).orElse(null);

        return obj;
    }
}