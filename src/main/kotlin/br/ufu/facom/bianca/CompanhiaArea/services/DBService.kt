package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.*
import br.ufu.facom.bianca.CompanhiaArea.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class DBService {

    @Autowired
    private lateinit var vooRepository: VooRepository

    @Autowired
    private lateinit var aeronaveRepository: AeronaveRepository

    @Autowired
    private lateinit var pilotoRepository: PilotoRepository

    @Autowired
    private lateinit var mecanicoRepository: MecanicoRepository

    @Autowired
    private lateinit var certificadoRepository: CertificadoRepository

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

        // Instância dos mecânicos
        var m1 = Mecanico(0, "Josefina", "82566409013", 9832.43)
        var m2 = Mecanico(0,"Hugo","85356650051", 2345.12)

        // Instância dos pilotos
        var p1 = Piloto(0, "Bianca","45671190029", 4563.76)
        var p2 = Piloto(0,"Paolo", "63943938000", 3215.34)

        mecanicoRepository.saveAll(Arrays.asList(m1,m2))
        pilotoRepository.saveAll(Arrays.asList(p1,p2))

        // Instância dos certificados dos pilotos
        var c1 = Certificado(0)
        var c2 = Certificado(0)

        c1.aeronave = a1
        c2.aeronave = a2

        certificadoRepository.saveAll(Arrays.asList(c1,c2))

        p1.certificados.add(c1)
        p1.certificados.add(c2)
        p2.certificados.add(c1)

        certificadoRepository.saveAll(Arrays.asList(c1,c2))
        pilotoRepository.saveAll(Arrays.asList(p1,p2))
    }
}