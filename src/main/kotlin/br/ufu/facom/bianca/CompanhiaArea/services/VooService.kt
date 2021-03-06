package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.dto.NewVooDTO
import br.ufu.facom.bianca.CompanhiaArea.dto.VooDTO
import br.ufu.facom.bianca.CompanhiaArea.repositories.VooRepository
import br.ufu.facom.bianca.CompanhiaArea.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VooService {

    @Autowired
    private lateinit var repo: VooRepository

    fun findById (id: Long): Voo {
        var obj = repo.findById(id)

        return obj.orElseThrow{ ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Voo::class.qualifiedName
        )}
    }

    fun insert (obj: Voo): Voo {
        // Método que insere um objeto no banco
        obj.id = 0   // Garante que não tem nenhum id ainda
        return this.repo.save(obj)
    }

    fun update (objDTO: VooDTO, id: Long): Voo {
        // Método que atualiza um objeto no banco

        // Procura o objeto pelo ID no banco
        var newObj = this.findById(id)

        // Atualiza o newObj
        this.updateData(newObj, objDTO)

        return repo.save(newObj)
    }

    fun updateData (newObj: Voo, objDTO: VooDTO) {
        // Esse método atualiza apenas algumas características de Voo
        // Caso algum valor de "objDTO" seja null, então o valor atual do "newObj" será mantido
        newObj.preco = objDTO?.preco?:newObj.preco
        newObj.distancia = objDTO?.distancia?:newObj.distancia
        newObj.partidaPrevista = objDTO.partidaPrevista?:newObj.partidaPrevista
        newObj.chegadaPrevista = objDTO.chegadaPrevista?:newObj.chegadaPrevista
        newObj.status = objDTO.status?:newObj.status
    }

    fun delete (id: Long) {
        this.findById(id)
        repo.deleteById(id)
    }

    fun fromDTO (objDTO: NewVooDTO): Voo {
        // Método que converte um objeto DTO em uma entidade normal
       return Voo(objDTO.id, objDTO.origem, objDTO.destino)
    }
}