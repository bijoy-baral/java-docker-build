package com.docker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("status")
public class Status {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String statusInformation() {
		return "\"dockerbuild\": [\r\n" + "{\r\n" + "\"version\": \"1.0\",\r\n"
				+ "\"description\" : \"pre-interview technical test\",\r\n" + "\"lastcommitsha\": \"xxyyzz123456\"\r\n"
				+ "}\r\n" + "]";
	}
}