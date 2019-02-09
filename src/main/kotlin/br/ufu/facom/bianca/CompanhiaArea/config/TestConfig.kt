package br.ufu.facom.bianca.CompanhiaArea.config

import br.ufu.facom.bianca.CompanhiaArea.services.DBService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("test")
class TestConfig {

    @Autowired
    private lateinit var dbService: DBService

    @Bean
    fun instanciateDataBase(): Boolean {
        dbService.instantiateTestDataBase()

        return true
    }
}