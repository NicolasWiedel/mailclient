package de.javadevblog.mailclient.controller;

import java.net.URL;
import java.util.ResourceBundle;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController implements Initializable {
	
	public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
    private TreeView<String> emailsTreeView;

    @FXML
    private WebView emailsWebView;

    @FXML
    private TableView<?> emailsTableView;

    @FXML
    void addAccountAction() {
    	viewFactory.showLoginWindow();
    }

    @FXML
    void optionsAction() {
    	viewFactory.showOptionsWindow();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setUpEmailsPreview();
		
	}

	private void setUpEmailsPreview() {
		emailsTreeView.setRoot(emailManager.getFoldersRoot());
		emailsTreeView.setShowRoot(false);
	}


}
