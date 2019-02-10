package br.ufu.facom.bianca.CompanhiaArea.domain

import org.hibernate.mapping.Join
import java.time.LocalDate
import javax.persistence.*
import java.util.Set

@Entity
data class Piloto (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var nome: String,
    var cpf: String,
    var salario: Number

) {

    @ManyToMany
    @JoinTable(name="certificados_id",
            joinColumns = [JoinColumn(name="certificado_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "piloto_id", referencedColumnName = "id")])
    var certificados: MutableSet<Certificado> = HashSet()

}