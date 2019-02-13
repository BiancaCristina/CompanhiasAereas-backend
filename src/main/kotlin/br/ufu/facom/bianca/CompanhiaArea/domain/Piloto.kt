package br.ufu.facom.bianca.CompanhiaArea.domain

import javax.persistence.*

@Entity
data class Piloto (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var nome: String,
    var cpf: String,
    var salario: Number ?= null

) {

    @ManyToMany
    @JoinTable(name="certificados_id",
            joinColumns = [JoinColumn(name="certificado_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "piloto_id", referencedColumnName = "id")])
    var certificados: MutableSet<Certificado> = HashSet()

}