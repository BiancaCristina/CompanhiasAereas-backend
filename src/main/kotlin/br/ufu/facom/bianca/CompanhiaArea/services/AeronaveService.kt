package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Aeronave
import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.repositories.AeronaveRepository
import br.ufu.facom.bianca.CompanhiaArea.repositories.VooRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AeronaveService {

    @Autowired
    private lateinit var repo: AeronaveRepository

    fun findById (id: Long): Aeronave {
        var obj = repo.findById(id).orElse(null)

        return obj
    }
}