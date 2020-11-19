package de.javadevblog.mailclient.controller;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.view.ViewFactory;

public abstract class BaseController {

	protected EmailManager emailManager;
	protected ViewFactory viewFactory;
	private String fxmlName;
	
	public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		this.emailManager = emailManager;
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}

	public String getFxmlName() {
		return fxmlName;
	}

	public void setFxmlName(String fxmlName) {
		this.fxmlName = fxmlName;
	}
	
	
}
