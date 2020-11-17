package br.edu.ifsc.reservation;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo(
				"Reservation microservice API",
				"API REST of reservations",
				"0.5",
				"Terms of Service:"
				+ "This product is based in a tutorial by Amir Boroumand",
				new Contact("Guilherme Pereira", null, "guilherme.vitorianop@gmail.com"),
				"Apache license Version 2.0",
				"https//www.apache.org/license.html", new ArrayList<VendorExtension>()
				);
		return apiInfo;
	}

}
