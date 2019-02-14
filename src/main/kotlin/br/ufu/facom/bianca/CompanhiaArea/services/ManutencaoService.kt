package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Manutencao
import br.ufu.facom.bianca.CompanhiaArea.dto.ManutencaoDTO
import br.ufu.facom.bianca.CompanhiaArea.repositories.AeronaveRepository
import br.ufu.facom.bianca.CompanhiaArea.repositories.ManutencaoRepository
import br.ufu.facom.bianca.CompanhiaArea.repositories.MecanicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ManutencaoService {

    @Autowired
    private lateinit var repo: ManutencaoRepository

    @Autowired
    private lateinit var aeronaveRepository: AeronaveRepository

    @Autowired
    private lateinit var mecanicoRepository: MecanicoRepository

    fun findById (id: Long): Manutencao {
        var obj = repo.findById(id).orElse(null)

        return obj
    }

    fun insert (obj: Manutencao): Manutencao {
        // Método que insere um objeto no banco
        obj.id = 0   // Garante que não tem nenhum id ainda
        return this.repo.save(obj)
    }

    fun update (objDTO: ManutencaoDTO, id: Long): Manutencao {
        // Método que atualiza um objeto no banco

        // Procura o objeto pelo ID no banco
        var newObj = this.findById(id)

        // Atualiza o newObj
        this.updateData(newObj, objDTO)

        return repo.save(newObj)
    }

    fun updateData (newObj: Manutencao, objDTO: ManutencaoDTO) {
        // Esse método atualiza apenas algumas características de Manutencao
        // Caso algum valor de "objDTO" seja null, então o valor atual do "newObj" será mantido
        //newObj.preco = objDTO?.preco?:newObj.preco
        newObj.data = objDTO.data
        newObj.aeronave = aeronaveRepository.findById(objDTO.aeronaveDTO.id).orElse(null)?:newObj.aeronave
    }

    fun delete (id: Long) {
        this.findById(id)
        repo.deleteById(id)
    }

    fun fromDTO (objDTO: ManutencaoDTO): Manutencao {
        // Método que converte um objeto DTO em uma entidade normal
        var obj = Manutencao(objDTO.id, objDTO.data)
        var aeronave = aeronaveRepository.findById(objDTO.aeronaveDTO.id).orElse(null)

        obj.aeronave = aeronave
        return obj
    }
}