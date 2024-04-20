package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class L27SpringCloudLbClientApplication {

	public static void main(String[] args) {
		//SpringApplication.run(L27SpringCloudLbClientApplication.class, args);
		
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(L27SpringCloudLbClientApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		WebClient loadBalancedClient = ctx.getBean(WebClient.Builder.class).build();
		
		for (int i = 0; i < 10; i++) {
			String response = 
					loadBalancedClient.get().uri("http://127.0.0.1/hello")
					.retrieve().toEntity(String.class)
					.block().getBody();
			System.out.println("Response :"+i+" ::"+response);
			
		}
	}

}

@Configuration
class DemoServerInstanceConfiguration{
	
	@Bean
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		
		return new DemoInstanceSupplier("127.0.0.1");
	}
}

@Configuration
@LoadBalancerClient(name="127.0.0.1",configuration =DemoInstanceSupplier.class )
class WebClientConfig{
	
	@Bean
	WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}
}

class DemoInstanceSupplier implements ServiceInstanceListSupplier{

	private final String serviceId;
	
	public DemoInstanceSupplier(String serviceId) {
        this.serviceId = serviceId;
    }
	
	@Override
	public Flux<List<ServiceInstance>> get() {
		// TODO Auto-generated method stub
		DefaultServiceInstance i1 = new DefaultServiceInstance(serviceId+"1", serviceId, "localhost", 8080, false);
		DefaultServiceInstance i2 = new DefaultServiceInstance(serviceId+"2", serviceId, "localhost", 8081, false);
		

		
		return Flux.just(Arrays.asList(i1,i2));
	}

	@Override
	public String getServiceId() {
		// TODO Auto-generated method stub
		return serviceId;
	}
	
}
