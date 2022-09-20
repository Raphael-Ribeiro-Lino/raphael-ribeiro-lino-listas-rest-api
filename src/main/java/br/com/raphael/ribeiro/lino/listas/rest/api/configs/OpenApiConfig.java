package br.com.raphael.ribeiro.lino.listas.rest.api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI springShowOpenApi() {
		OpenAPI openApi = new OpenAPI();
		Info info = new Info();
		info.title("Acelera G&P Avaliação 03");
		info.version("v.0.0.1");
		info.description("<h2>Descreve a comunicação do sistema da avaliação 03</h2>");
		openApi.info(info);
		openApi.addTagsItem(new Tag().name("Lista").description("Gerencia as listas do sistema"));
		openApi.addTagsItem(new Tag().name("Item").description("Gerencia os itens do sistema"));
		
		return openApi;
	}
}
