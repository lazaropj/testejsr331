package br.com.linkout.aluno;

import javax.json.stream.JsonGenerator;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class FresquinResourceConfig extends ResourceConfig{

	public FresquinResourceConfig(){
		 	register(JsonProcessingFeature.class)
	        .packages("br.com.linkout.aluno")
	        .property(JsonGenerator.PRETTY_PRINTING, true);
	}
}
