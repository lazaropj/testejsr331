package br.com.linkout.aluno;

import java.util.HashSet;
import java.util.Set;

import javax.json.stream.JsonGenerator;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;

public class FresquinApplication extends Application  {

	 @Override
	    public Set<Class<?>> getClasses() {
	        Set<Class<?>> s = new HashSet<Class<?>>();
	        
	        s.add(AlunoProvider.class);
	    /*    .register(JsonProcessingFeature.class)
        .packages("org.glassfish.jersey.examples.jsonp")
        .property(JsonGenerator.PRETTY_PRINTING, true);*/
	        
	        return s;
	    }
	 
}
