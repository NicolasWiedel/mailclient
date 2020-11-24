package de.javadevblog.mailclient.controller.services;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.controller.EmailLoginReult;
import de.javadevblog.mailclient.model.EmailAccount;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<EmailLoginReult> {

	private EmailAccount mailAccount;
	private EmailManager emailManager;
	public LoginService(EmailAccount mailAccount, EmailManager emailManager) {
		this.mailAccount = mailAccount;
		this.emailManager = emailManager;
	}
	
	public EmailLoginReult login() {
		Authenticator authentificator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(mailAccount.getAddress(), mailAccount.getPassword());
			}
		};
		
		try {
			Session session = Session.getInstance(mailAccount.getProperties(), authentificator);
			Store store = session.getStore("imaps");
			store.connect(mailAccount.getProperties().getProperty("incomingHost"),
					mailAccount.getAddress(), mailAccount.getPassword());
			mailAccount.setStore(store);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return EmailLoginReult.FAILED_BY_NETWORK;
		}catch (AuthenticationFailedException e) {
			e.printStackTrace();
			return EmailLoginReult.FAILED_BY_CREDENTIALS;
		} catch (MessagingException e) {
			e.printStackTrace();
			return EmailLoginReult.FAILED_BY_UNEXPECTED_ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return EmailLoginReult.FAILED_BY_UNEXPECTED_ERROR;
		}
		return EmailLoginReult.SUCCESS;
	}

	@Override
	protected Task<EmailLoginReult> createTask() {
		return new Task<EmailLoginReult>() {
			@Override
			protected EmailLoginReult call() throws Exception {
				return login();
			}
		};
	}
}
