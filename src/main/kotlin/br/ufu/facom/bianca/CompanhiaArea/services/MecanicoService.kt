package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Mecanico
import br.ufu.facom.bianca.CompanhiaArea.dto.MecanicoDTO
import br.ufu.facom.bianca.CompanhiaArea.repositories.MecanicoRepository
import br.ufu.facom.bianca.CompanhiaArea.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MecanicoService {

    @Autowired
    private lateinit var repo: MecanicoRepository

    fun findById (id: Long): Mecanico {
        var obj = repo.findById(id)

        return obj.orElseThrow{ ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Mecanico::class.qualifiedName
        )
        }
    }

    fun insert (obj: Mecanico): Mecanico {
        // Método que insere um objeto no banco
        obj.id = 0   // Garante que não tem nenhum id ainda
        return this.repo.save(obj)
    }

    fun update (objDTO: MecanicoDTO, id: Long): Mecanico {
        // Método que atualiza um objeto no banco

        // Procura o objeto pelo ID no banco
        var newObj = this.findById(id)

        // Atualiza o newObj
        this.updateData(newObj, objDTO)

        return repo.save(newObj)
    }

    fun updateData (newObj: Mecanico, objDTO: MecanicoDTO) {
        // Esse método atualiza apenas algumas características de Mecanico
        // Caso algum valor de "objDTO" seja null, então o valor atual do "newObj" será mantido
        newObj.nome = objDTO.nome
        newObj.cpf = objDTO.cpf
    }

    fun delete (id: Long) {
        this.findById(id)
        repo.deleteById(id)
    }

    fun fromDTO (objDTO: MecanicoDTO): Mecanico {
        // Método que converte um objeto DTO em uma entidade normal
        return Mecanico(objDTO.id, objDTO.nome, objDTO.cpf)
    }
}