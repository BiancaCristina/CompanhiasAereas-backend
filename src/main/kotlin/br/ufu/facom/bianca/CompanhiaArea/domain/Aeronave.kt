package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Aeronave (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var nome: String,
        var distanciaLimite: Number
) {
    @JsonIgnore
    @OneToMany(mappedBy="aeronave")
    var voos: MutableSet<Voo> = HashSet()

    @JsonIgnore
    @OneToOne(mappedBy = "aeronave")
    lateinit var certificado: Certificado

    //var manuntencoes
    //var teste = Voo(0,"Uberlândia", "São Paulo", 590.4, 312.32)

}