module MailClient {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	
	opens de.javadevblog.mailclient;
	opens de.javadevblog.mailclient.controller;
}