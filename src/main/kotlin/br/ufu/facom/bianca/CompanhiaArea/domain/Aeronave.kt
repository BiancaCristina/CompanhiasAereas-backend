package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Aeronave (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        var nome: String,
        var distanciaLimite: Number ?= null
) {
    @JsonIgnore
    @OneToMany(mappedBy="aeronave")
    var voos: MutableSet<Voo> = HashSet()

    @JsonIgnore
    @OneToOne(mappedBy = "aeronave")
    lateinit var certificado: Certificado

    @JsonIgnore
    @OneToMany(mappedBy = "aeronave")
    var manutencoes: MutableSet<Manutencao> = HashSet()
}