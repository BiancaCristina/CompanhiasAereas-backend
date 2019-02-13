package br.ufu.facom.bianca.CompanhiaArea.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Mecanico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var nome: String,
    var cpf: String,
    var salario: Number ?= null
) {

    @JsonIgnore
    @ManyToMany(mappedBy = "mecanicos")
    var manutencoes: MutableSet<Manutencao> = HashSet()

}