package br.ufu.facom.bianca.CompanhiaArea.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Mecanico (
    @Id @GeneratedValue
    override val id: Long,

    override var nome: String,
    override var cpf: String,
    override var salario: Number
): Funcionario (id, nome, cpf, salario) {

    // Relatorios de manuntencao

}