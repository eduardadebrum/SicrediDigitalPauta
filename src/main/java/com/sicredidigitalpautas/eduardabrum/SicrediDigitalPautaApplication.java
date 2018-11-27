package com.sicredidigitalpautas.eduardabrum;


import com.sicredidigitalpautas.eduardabrum.repository.RepositoryPackageMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Classe para inicialização do Deploy da aplicação.
 *
 * @author Eduarda de Brum Lucena
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@EnableJpaRepositories(basePackageClasses = {RepositoryPackageMarker.class})
public class SicrediDigitalPautaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SicrediDigitalPautaApplication.class, args);
    }
}
