package br.ufu.facom.bianca.CompanhiaArea.resources

import br.ufu.facom.bianca.CompanhiaArea.dto.PilotoDTO
import br.ufu.facom.bianca.CompanhiaArea.services.PilotoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping(value=["/pilotos"])
class PilotoResource {

    @Autowired
    private lateinit var service: PilotoService

    @RequestMapping(value=["/{id}"], method= [RequestMethod.GET])
    fun find(@PathVariable id: Long): ResponseEntity<*> {
        // Função que busca um objeto pelo seu ID
        // O retorno é uma resposta OK e o corpo do objeto

        var obj = service.findById(id)
        return ResponseEntity.ok().body(obj)
    }

    @RequestMapping(method=[RequestMethod.POST])
    fun insert(@Valid @RequestBody objDTO: PilotoDTO): ResponseEntity<Unit> {
        // Esse método converte o objDTO recebido como parâmetro em uma entidade normal e o insere

        var obj = service.fromDTO(objDTO)
        obj = service.insert(obj)

        // Retorna a URI do objeto criado
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri()

        return ResponseEntity.created(uri).build()
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.PUT])
    fun update(@Valid @RequestBody objDTO: PilotoDTO,
               @PathVariable id: Long): ResponseEntity<Unit> {
        this.service.update(objDTO, id)

        return ResponseEntity.noContent().build()
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.DELETE])
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)

        return ResponseEntity.noContent().build()
    }
}