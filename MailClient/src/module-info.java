module MailClient {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	requires activation;
	requires java.mail;
	
	opens de.javadevblog.mailclient;
	opens de.javadevblog.mailclient.view;
	opens de.javadevblog.mailclient.controller;
}