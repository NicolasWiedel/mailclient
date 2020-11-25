package de.javadevblog.mailclient;

import de.javadevblog.mailclient.controller.services.FetchFolderService;
import de.javadevblog.mailclient.model.EmailAccount;
import de.javadevblog.mailclient.model.EmailTreeItem;

public class EmailManager {
	
	// Folder Handling
	private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

	public EmailTreeItem<String> getFoldersRoot() {
		return foldersRoot;
	}

	public void addEmailAccount(EmailAccount emailAccount) {
		EmailTreeItem<String> emailTreeItem = new EmailTreeItem<String>(emailAccount.getAddress());
		FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), emailTreeItem);
		fetchFolderService.start();
		foldersRoot.getChildren().add(emailTreeItem);
	}
}
