package com.sinch.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BoardApplication implements CommandLineRunner {

	/**
			* The Constant logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(BoardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info(
				"***************************************************************************************************");
		logger.info("<----------------Leader Board Rest API --- startup command-line initiated------------------------>");
		logger.info(
				"***************************************************************************************************");
	}

	/**
	 * The Class RESTController.
	 */
	@RestController
	class RESTController {

		/**
		 * Hello.
		 *
		 * @return the string
		 */
		@RequestMapping("/")
		public String hello() {
			return "<H1>Leader Board Rest API----------Spring Boot Application Rest Endpoints Activated</H1>";
		}
	}

}
