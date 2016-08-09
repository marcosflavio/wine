package com.marcosf.wine.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	// Classe responsável por customizar as páginas de erros
	
	//Bean é um objeto que vai configurar algo
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		
		return (container ->
			container.addErrorPages(new org.springframework.boot.context.embedded.ErrorPage(HttpStatus.NOT_FOUND, "/404"))
				
				);
	}
	
	//Com esse bean, ele já consegue entregar o vinho diretamente no método visualizar.
	@Bean
	public DomainClassConverter<FormattingConversionService> domainClassConverter(
			FormattingConversionService conversionService){
		
		return new DomainClassConverter<FormattingConversionService>(conversionService);
	}
	
}
