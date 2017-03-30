package com.danielpsf.labs.server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/echo")
public class EchoController {

	private final Logger LOG = LoggerFactory.getLogger(EchoController.class);
	
	private Session session;

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		this.session.getAsyncRemote().sendText("Welcome dude...");
		LOG.debug("Welcome dude...");
	}
	
	@OnClose
	public void onClose(Session session) {
		session.getAsyncRemote().sendText("Good bye! :)");
		LOG.debug("Welcome dude...");
	}
	
	@OnMessage
	public void onMessage(String msg) {
		session.getAsyncRemote().sendText("Hey dude: " + msg);
		LOG.debug("Hey dude: " + msg);
	}
}
