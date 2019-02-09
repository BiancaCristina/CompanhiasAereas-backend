package br.ufu.facom.bianca.CompanhiaArea.resources

import br.ufu.facom.bianca.CompanhiaArea.domain.Voo
import br.ufu.facom.bianca.CompanhiaArea.services.VooService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value="/voos")
class VooResource {

    @Autowired
    private lateinit var vooService: VooService

    @RequestMapping(value="/{id}", method= [RequestMethod.GET])
    fun find(@PathVariable id: Long): ResponseEntity<*> {
        // Função que busca um objeto pelo seu ID
        // O retorno é uma resposta OK e o corpo do objeto

        var obj = vooService.findById(id)
        return ResponseEntity.ok().body(obj)
    }


}