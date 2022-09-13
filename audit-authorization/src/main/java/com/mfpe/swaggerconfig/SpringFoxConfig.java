package com.mfpe.swaggerconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * This class is used for the configuration and customization of
 * swagger. 
 * Swagger is used to describe and document RESTful APIs 
 * with Swagger user will able to see the end-points to access the
 * application.
 *
 */
@Configuration
@EnableSwagger2 @Slf4j
public class SpringFoxConfig { 
	/**
	 * 
	 * @return Docket object
	 * We are creating a Docket bean in a Spring Boot configuration to configure
	 * Swagger 2 for the application. 
	 * A Springfox Docket instance provides the primary API configuration with sensible defaults 
	 * and convenience methods for configuration
	 *
	 */
	
	@Bean
	public Docket api() { 

		Docket docket= new Docket(DocumentationType.SWAGGER_2)  
				.select()                                  
				.apis(RequestHandlerSelectors.any())              
				.paths(PathSelectors.any())                          
				.build().apiInfo(apiDetails()); 
		log.debug("Docket{}:", docket);
		return docket;
	}
	
	/**
	 * 
	 * @return ApiInfo object
	 * ApiInfo allows to provide Customized information for Docket Swagger_2
	 * Customized Information -
	 * 	 Title for API
	 * 	 Description of API
	 * 	 Terms of Service Url
	 * 	 License
	 * 	 Contact Information
	 * 	 Version of API
	 * 		
	 */
	private ApiInfo apiDetails() {
		ApiInfo apiInfo= new ApiInfoBuilder()
				.title("Audit-Authorization")
				.description("This is the Audit Authorization Microservice")		
				.build();
		log.debug("API Info{}:", apiInfo);
		return apiInfo;
	}
}