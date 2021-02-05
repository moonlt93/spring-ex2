package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class SampleController {

	
	// postman request body
	// {"tno":55,"owner":"donald","grade":"vip"}
	@PostMapping("/ticket")
	public Ticket conver(@RequestBody Ticket ticket) {
		log.info(ticket);

		return ticket;
	}

	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		SampleVO s = new SampleVO();
		s.setFirstName("donald");
		
		return s;
	}
	
	
}
