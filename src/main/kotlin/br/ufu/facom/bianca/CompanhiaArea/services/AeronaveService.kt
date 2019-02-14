package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Aeronave
import br.ufu.facom.bianca.CompanhiaArea.dto.AeronaveDTO
import br.ufu.facom.bianca.CompanhiaArea.repositories.AeronaveRepository
import br.ufu.facom.bianca.CompanhiaArea.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AeronaveService {

    @Autowired
    private lateinit var repo: AeronaveRepository

    fun findById (id: Long): Aeronave {
        var obj = repo.findById(id)

        return obj.orElseThrow{ ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Aeronave::class.qualifiedName
        )
        }
    }

    fun insert (obj: Aeronave): Aeronave {
        // Método que insere um objeto no banco
        obj.id = 0   // Garante que não tem nenhum id ainda
        return this.repo.save(obj)
    }

    fun fromDTO (objDTO: AeronaveDTO): Aeronave {
        // Método que converte um objeto DTO em uma entidade normal
        return Aeronave(objDTO.id, objDTO.nome)
    }

    fun update (objDTO: AeronaveDTO, id: Long): Aeronave {
        // Método que atualiza um objeto no banco

        // Procura o objeto pelo ID no banco
        var newObj = this.findById(id)

        // Atualiza o newObj
        this.updateData(newObj, objDTO)

        return repo.save(newObj)
    }

    fun updateData (newObj: Aeronave, objDTO: AeronaveDTO) {
        // Esse método atualiza apenas algumas características de Aeronave
        // Caso algum valor de "objDTO" seja null, então o valor atual do "newObj" será mantido
        newObj.nome = objDTO.nome
    }

    fun delete (id: Long) {
        this.findById(id)
        repo.deleteById(id)
    }
}