package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Piloto
import br.ufu.facom.bianca.CompanhiaArea.dto.PilotoDTO
import br.ufu.facom.bianca.CompanhiaArea.repositories.PilotoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PilotoService {

    @Autowired
    private lateinit var repo: PilotoRepository

    fun findById (id: Long): Piloto {
        var obj = repo.findById(id).orElse(null);

        return obj;
    }

    fun insert (obj: Piloto): Piloto {
        // Método que insere um objeto no banco
        obj.id = 0   // Garante que não tem nenhum id ainda
        return this.repo.save(obj)
    }

    fun update (objDTO: PilotoDTO, id: Long): Piloto {
        // Método que atualiza um objeto no banco

        // Procura o objeto pelo ID no banco
        var newObj = this.findById(id)

        // Atualiza o newObj
        this.updateData(newObj, objDTO)

        return repo.save(newObj)
    }

    fun updateData (newObj: Piloto, objDTO: PilotoDTO) {
        // Esse método atualiza apenas algumas características de Piloto
        // Caso algum valor de "objDTO" seja null, então o valor atual do "newObj" será mantido
        newObj.nome = objDTO.nome
        newObj.cpf = objDTO.cpf
    }

    fun delete (id: Long) {
        this.findById(id)
        repo.deleteById(id)
    }

    fun fromDTO (objDTO: PilotoDTO): Piloto {
        // Método que converte um objeto DTO em uma entidade normal
        return Piloto(objDTO.id, objDTO.nome, objDTO.cpf)
    }
}