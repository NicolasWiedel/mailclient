package de.javadevblog.mailclient.controller.services;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.controller.EmailLoginReult;
import de.javadevblog.mailclient.model.EmailAccount;

public class LoginService {

	private EmailAccount mailAccount;
	private EmailManager emailManager;
	public LoginService(EmailAccount mailAccount, EmailManager emailManager) {
		this.mailAccount = mailAccount;
		this.emailManager = emailManager;
	}
	
	public EmailLoginReult login() {
		return null;
	}
}
