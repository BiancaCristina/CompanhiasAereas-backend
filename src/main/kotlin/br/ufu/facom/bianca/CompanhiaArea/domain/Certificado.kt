package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*
import java.util.Set

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