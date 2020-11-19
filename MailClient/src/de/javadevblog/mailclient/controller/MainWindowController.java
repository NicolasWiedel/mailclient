package de.javadevblog.mailclient.controller;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {
	
	public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
    private TreeView<?> emailsTreeView;

    @FXML
    private WebView emailsWebView;

    @FXML
    private TableView<?> emailsTableView;

    @FXML
    void addAccountAction() {

    }

    @FXML
    void optionsAction() {

    }


}
