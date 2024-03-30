package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L21EmbeddedServerExamplesApplication {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger("abc");
		
		logger.info("This is an Info Log");
		logger.warn("This is an Warning Log");
		logger.debug("This is an Debug Log");
		logger.trace("This is an Trace Log");
		SpringApplication.run(L21EmbeddedServerExamplesApplication.class, args);
	}
	/**
	 * ERROR : severe and minmum
	 * INFO: know and debug
	 * DEBUG: INFO + Extra debugging
	 * TRACE: slighest change...hearbeat 
	 * @return
	 */
	
	@GetMapping("/test")
	public String test() {
		return "This is running on the Jetty Server";
	}
	/*
	 * 
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.2.4)[0;39m

[2m2024-03-30T20:53:04.896+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36me.d.L21EmbeddedServerExamplesApplication[0;39m [2m:[0;39m Starting L21EmbeddedServerExamplesApplication using Java 17.0.7 with PID 32661 (/Users/adityadua/Documents/JBDL-65/L21_Embedded_Server_Examples/target/classes started by adityadua in /Users/adityadua/Documents/JBDL-65/L21_Embedded_Server_Examples)
[2m2024-03-30T20:53:04.900+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36me.d.L21EmbeddedServerExamplesApplication[0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2024-03-30T20:53:05.849+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.s.b.w.e.j.JettyServletWebServerFactory[0;39m [2m:[0;39m Server initialized with port: 8080
[2m2024-03-30T20:53:05.853+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36morg.eclipse.jetty.server.Server         [0;39m [2m:[0;39m jetty-12.0.7; built: 2024-02-29T21:19:41.771Z; git: c89aca8fd34083befd79f328a3b8b6ffff04347e; jvm 17.0.7+7
[2m2024-03-30T20:53:05.884+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.e.j.s.h.ContextHandler.application    [0;39m [2m:[0;39m Initializing Spring embedded WebApplicationContext
[2m2024-03-30T20:53:05.885+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mw.s.c.ServletWebServerApplicationContext[0;39m [2m:[0;39m Root WebApplicationContext: initialization completed in 928 ms
[2m2024-03-30T20:53:05.941+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.e.j.session.DefaultSessionIdManager   [0;39m [2m:[0;39m Session workerName=node0
[2m2024-03-30T20:53:05.948+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.e.jetty.server.handler.ContextHandler [0;39m [2m:[0;39m Started osbwej.JettyEmbeddedWebAppContext@1a3e8e24{application,/,b=file:/private/var/folders/_n/8btl73h10pj1gpzmmtnvf0gm0000gn/T/jetty-docbase.8080.11271791017225563539/,a=AVAILABLE,h=oeje10s.SessionHandler@4ed4a7e4{STARTED}}
[2m2024-03-30T20:53:05.948+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.e.j.e.servlet.ServletContextHandler   [0;39m [2m:[0;39m Started osbwej.JettyEmbeddedWebAppContext@1a3e8e24{application,/,b=file:/private/var/folders/_n/8btl73h10pj1gpzmmtnvf0gm0000gn/T/jetty-docbase.8080.11271791017225563539/,a=AVAILABLE,h=oeje10s.SessionHandler@4ed4a7e4{STARTED}}
[2m2024-03-30T20:53:05.950+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36morg.eclipse.jetty.server.Server         [0;39m [2m:[0;39m Started oejs.Server@4d18b73a{STARTING}[12.0.7,sto=0] @2335ms
[2m2024-03-30T20:53:06.242+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.e.j.s.h.ContextHandler.application    [0;39m [2m:[0;39m Initializing Spring DispatcherServlet 'dispatcherServlet'
[2m2024-03-30T20:53:06.242+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.s.web.servlet.DispatcherServlet       [0;39m [2m:[0;39m Initializing Servlet 'dispatcherServlet'
[2m2024-03-30T20:53:06.243+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.s.web.servlet.DispatcherServlet       [0;39m [2m:[0;39m Completed initialization in 1 ms
[2m2024-03-30T20:53:06.258+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.e.jetty.server.AbstractConnector      [0;39m [2m:[0;39m Started ServerConnector@7adc6fe1{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
[2m2024-03-30T20:53:06.259+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36mo.s.b.web.embedded.jetty.JettyWebServer [0;39m [2m:[0;39m Jetty started on port 8080 (http/1.1) with context path '/'
[2m2024-03-30T20:53:06.267+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [           main][0;39m [2m[0;39m[36me.d.L21EmbeddedServerExamplesApplication[0;39m [2m:[0;39m Started L21EmbeddedServerExamplesApplication in 1.807 seconds (process running for 2.652)
[2m2024-03-30T20:55:01.050+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [n(11)-127.0.0.1][0;39m [2m[0;39m[36minMXBeanRegistrar$SpringApplicationAdmin[0;39m [2m:[0;39m Application shutdown requested.
[2m2024-03-30T20:55:01.055+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [n(11)-127.0.0.1][0;39m [2m[0;39m[36mo.e.jetty.server.AbstractConnector      [0;39m [2m:[0;39m Stopped ServerConnector@7adc6fe1{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
[2m2024-03-30T20:55:01.057+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [n(11)-127.0.0.1][0;39m [2m[0;39m[36morg.eclipse.jetty.server.Server         [0;39m [2m:[0;39m Stopped oejs.Server@4d18b73a{STOPPING}[12.0.7,sto=0]
[2m2024-03-30T20:55:01.059+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [n(11)-127.0.0.1][0;39m [2m[0;39m[36mo.e.j.s.h.ContextHandler.application    [0;39m [2m:[0;39m Destroying Spring FrameworkServlet 'dispatcherServlet'
[2m2024-03-30T20:55:01.060+05:30[0;39m [32m INFO[0;39m [35m32661[0;39m [2m---[0;39m [2m[L21_Embedded_Server_Examples] [n(11)-127.0.0.1][0;39m [2m[0;39m[36mo.e.j.e.servlet.ServletContextHandler   [0;39m [2m:[0;39m Stopped osbwej.JettyEmbeddedWebAppContext@1a3e8e24{application,/,b=file:/private/var/folders/_n/8btl73h10pj1gpzmmtnvf0gm0000gn/T/jetty-docbase.8080.11271791017225563539/,a=AVAILABLE,h=oeje10s.SessionHandler@4ed4a7e4{STOPPED}}

	 * */

}
