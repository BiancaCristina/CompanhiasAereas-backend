package br.ufu.facom.bianca.CompanhiaArea.resources

import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.dto.NewVooDTO
import br.ufu.facom.bianca.CompanhiaArea.dto.VooDTO
import br.ufu.facom.bianca.CompanhiaArea.services.VooService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.xml.ws.Response

@RestController
@RequestMapping(value=["/voos"])
class VooResource {

    @Autowired
    private lateinit var vooService: VooService

    @RequestMapping(value=["/{id}"], method= [RequestMethod.GET])
    fun find(@PathVariable id: Long): ResponseEntity<*> {
        // Função que busca um objeto pelo seu ID
        // O retorno é uma resposta OK e o corpo do objeto

        var obj = vooService.findById(id)
        return ResponseEntity.ok().body(obj)
    }

    @RequestMapping(method=[RequestMethod.POST])
    fun insert(@Valid @RequestBody objDTO: NewVooDTO): ResponseEntity<*> {
        // Esse método converte o objDTO recebido como parâmetro em uma entidade normal e o insere

        var obj = vooService.fromDTO(objDTO)
        obj = vooService.insert(obj)
        return ResponseEntity.ok().body(obj)
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.PUT])
    fun update(@Valid @RequestBody objDTO: VooDTO,
               @PathVariable id: Long): ResponseEntity<Unit> {
        //var obj = vooService.findById(id)
        //obj.id = id // Garante que o ID passado como parâmetro pertence ao objeto a ser atualizado
        this.vooService.update(objDTO, id)

        return ResponseEntity.noContent().build()
        //return ResponseEntity.ok().body(obj)
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.DELETE])
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        vooService.delete(id)

        return ResponseEntity.noContent().build()
    }

}