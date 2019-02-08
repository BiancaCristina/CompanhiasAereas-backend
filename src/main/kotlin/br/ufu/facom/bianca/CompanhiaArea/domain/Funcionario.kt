package br.ufu.facom.bianca.CompanhiaArea.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
abstract class Funcionario (
    @Id @GeneratedValue
    open val id: Long,

    open var nome: String,
    open var cpf: String,
    open var salario: Number
) {


}