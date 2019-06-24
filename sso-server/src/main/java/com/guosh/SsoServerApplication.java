/**
 * 
 */
package com.guosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author guosh
 *
 */
@SpringBootApplication
@RestController
public class SsoServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SsoServerApplication.class, args);
	}


	@GetMapping("/api/userinfo")
	public Principal user(Principal principal) {
		return principal;
	}
}
