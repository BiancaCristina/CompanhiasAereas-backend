package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Certificado (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
) {

    @OneToOne
    @JoinColumn(name= "aeronave_id")
    lateinit var aeronave: Aeronave

    @JsonIgnore
    @ManyToMany(mappedBy = "certificados")
    var pilotos: MutableSet<Piloto> = HashSet()

}