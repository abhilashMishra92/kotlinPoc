package com.poc.kotlinpoc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
open class SwaggerConfig {

    @Bean
    open fun productAPI(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select().apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/poc/.*"))
            .build()
            .apiInfo(apiInfo())

    fun apiInfo(): ApiInfo = ApiInfoBuilder()
            .title("Kotlin-MongoDB POC App")
            .description("***POC app for interacting with MongoDB with Kotlin***")
            .contact(Contact("Abhilash Mishra", "", "Abhilash.Mishra@target.com"))
            .version("1.0")
            .build()
}