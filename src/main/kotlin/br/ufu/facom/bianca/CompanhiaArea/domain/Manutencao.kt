package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Manutencao (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    // Aeronave
    @JsonFormat(pattern = "dd/MM/yyyy")
    var data: LocalDate

) {
    @ManyToMany
    @JoinTable(name="mecanicos_id",
            joinColumns = [JoinColumn(name="mecanico_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name="manutencao_id", referencedColumnName = "id")])
    var mecanicos: MutableSet<Mecanico> = HashSet()

    @ManyToOne
    @JoinColumn(name="aeronave_id")
    lateinit var aeronave: Aeronave
}