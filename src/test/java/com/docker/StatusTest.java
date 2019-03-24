package com.docker;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.docker.App;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class StatusTest {

  private HttpServer server;
  private WebTarget target;

  @Before
  public void setUp() {
    server = App.startServer();
    Client c = ClientBuilder.newClient();
    target = c.target(App.BASE_URI);
  }

  @After
  public void tearDown() {
    server.shutdownNow();
  }

  @Test
  public void shouldReceiveIdleStatus() {
    String responseMsg = target.path("status").request().get(String.class);
    final String expectedString = "\"dockerbuild\": [\r\n" + 
			"{\r\n" + 
			"\"version\": \"1.0\",\r\n" + 
			"\"description\" : \"pre-interview technical test\",\r\n" + 
			"\"lastcommitsha\": \"xxyyzz123456\"\r\n" + 
			"}\r\n" + 
			"]";
    assertEquals(expectedString, responseMsg);
  }
}
