package br.ufu.facom.bianca.CompanhiaArea.services

import br.ufu.facom.bianca.CompanhiaArea.domain.Aeronave
import br.ufu.facom.bianca.CompanhiaArea.domain.Certificado
import br.ufu.facom.bianca.CompanhiaArea.dto.AeronaveDTO
import br.ufu.facom.bianca.CompanhiaArea.repositories.AeronaveRepository
import br.ufu.facom.bianca.CompanhiaArea.repositories.CertificadoRepository
import br.ufu.facom.bianca.CompanhiaArea.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CertificadoService {

    @Autowired
    private lateinit var repo: CertificadoRepository

    @Autowired
    private lateinit var repoAeronave: AeronaveRepository

    fun findById (id: Long): Certificado {
        var obj = repo.findById(id)

        return obj.orElseThrow{ ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Certificado::class.qualifiedName
        )
        }
    }

    fun insert (aeronaveDTO: AeronaveDTO): Certificado {
        // Método que insere um objeto no banco
        var obj: Certificado = Certificado(0) // Garante que não tem nenhum id ainda
        obj.aeronave = repoAeronave.findById(aeronaveDTO.id).orElse(null) // Posteriormente trocar pra achar a aeronave por nome

        return this.repo.save(obj)
    }

    fun update (objDTO: AeronaveDTO, id: Long): Certificado {
        // Método que atualiza um objeto no banco

        // Procura o objeto pelo ID no banco
        var newObj = this.findById(id)

        // Procura a aeronave pelo ID no banco (retorna uma Aeronave)
        var newObjDTO = repoAeronave.findById(objDTO.id).orElse(null)

        // Atualiza o newObj
        this.updateData(newObj, newObjDTO)

        return repo.save(newObj)
    }

    fun updateData (newObj: Certificado, aeronave: Aeronave) {
        // Esse método atualiza apenas algumas características de Certificado

        // Atualiza a aeronave do certificado
        newObj.aeronave = aeronave
    }

    fun delete (id: Long) {
        this.findById(id)
        repo.deleteById(id)
    }
}