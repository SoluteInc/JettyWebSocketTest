package com.example.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class TestWebSocket {
	
	private static Map<String, MyClass> connections = 
			Collections.synchronizedMap(new HashMap<String, MyClass>());
	
	
	public TestWebSocket() {
	}
		
	
	@OnMessage
    public void onMessage(Session session, String message) {
		connections.get(session.getId()).test();
    }
	
	
	@OnOpen
    public void onOpen (Session session) {
		MyClass myClass = new MyClass();
        connections.put(session.getId(), myClass);
        System.out.println("My Class Created Via WebSocket");
    }

    @OnClose
    public void onClose (Session session) {
    	connections.remove(session);
    }
}