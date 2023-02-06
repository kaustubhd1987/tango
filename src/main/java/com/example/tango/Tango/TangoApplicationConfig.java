package com.example.tango.Tango;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.tango.Tango.filter.TangoFilter;
import com.example.tango.Tango.model.Party;
import com.example.tango.Tango.model.repository.PartyRepository;

@Configuration
public class TangoApplicationConfig {

	private static final Logger log = LoggerFactory.getLogger(TangoApplicationConfig.class);
	
	  @Bean
	  CommandLineRunner initDatabase(PartyRepository repository) {
	    return args -> {
	      log.info("Preloading " + repository.save(new Party(1L, "Bilbo Baggins", "burglar")));
	      log.info("Preloading " + repository.save(new Party(2L, "Frodo Baggins", "thief")));
	    };
	  }
	  
	  @Bean
	  public FilterRegistrationBean < TangoFilter > filterRegistrationBean() {
	   FilterRegistrationBean < TangoFilter > registrationBean = new FilterRegistrationBean();
	   TangoFilter tangoFilter = new TangoFilter();

	   registrationBean.setFilter(tangoFilter);
	   registrationBean.addUrlPatterns("/tango/*");
	   registrationBean.setOrder(1); //set precedence
	   return registrationBean;
	  }
}
