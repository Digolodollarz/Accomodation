package tech.diggle.apps.accomodation

//import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
class AccomodationApplication {
    @Override
    protected fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(applicationClass)
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(AccomodationApplication::class.java, *args)
}

val applicationClass = AccomodationApplication::class.java
