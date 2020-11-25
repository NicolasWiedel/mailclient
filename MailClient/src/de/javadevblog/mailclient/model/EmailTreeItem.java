package de.javadevblog.mailclient.model;

import javafx.scene.control.TreeItem;

public class EmailTreeItem<String> extends TreeItem<String> {
	
	private String name;

	public EmailTreeItem(String name) {
		super(name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
