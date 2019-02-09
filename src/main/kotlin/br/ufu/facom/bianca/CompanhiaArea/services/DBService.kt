package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.repositories.VooRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DBService {

    @Autowired
    private lateinit var vooRepository: VooRepository

    fun instantiateTestDataBase(): Unit {
        // Instância dos voo
        var v1 = Voo(0,"Uberlândia", "São Paulo")
        var v2 = Voo(0,"Manaus", "Salvador")
        var v3 = Voo(0, "Porto Alegre", "Salvador")

        vooRepository.saveAll(Arrays.asList(v1, v2, v3))
    }
}