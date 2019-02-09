package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Aeronave
import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.repositories.AeronaveRepository
import br.ufu.facom.bianca.CompanhiaArea.repositories.VooRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DBService {

    @Autowired
    private lateinit var vooRepository: VooRepository

    @Autowired
    private lateinit var aeronaveRepository: AeronaveRepository

    fun instantiateTestDataBase(): Unit {
        // Instância dos voo
        var v1 = Voo(0,"Uberlândia", "São Paulo", 590.4, 312.32)
        var v2 = Voo(0,"Manaus", "Salvador", 4859.2, 500.78)
        var v3 = Voo(0, "Porto Alegre", "Salvador", 3108.0, 452.76)

        // Instância das aeronaves
        var a1 = Aeronave(0, "Tachikawa Ki-9", 15232.014)
        var a2 = Aeronave(0, "Boeing E-3 Sentry", 56879.17)

        // Adiciona aeronaves nos voos
        v1.aeronave = a1
        v2.aeronave = a2
        v3.aeronave = a2

        aeronaveRepository.saveAll(Arrays.asList(a1,a2))
        vooRepository.saveAll(Arrays.asList(v1, v2, v3))

    }
}