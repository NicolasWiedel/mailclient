package de.javadevblog.mailclient.model;

import java.util.Properties;

import javax.mail.Store;

public class EmailAccount {

	private String address;
	private String password;
	private Properties properties;
	private Store store;
	public EmailAccount(String address, String password) {
		this.address = address;
		this.password = password;
		properties = new Properties();
		
		properties.put("incomingHost", "imap.one.com");
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.transport.protocol", "smtps");
		properties.put("mail.smtp.host", "send.one.com");
		properties.put("mail.smtps.auth", "true");
		properties.put("outgoingHost", "send.one.com");
	}
	
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	
}
