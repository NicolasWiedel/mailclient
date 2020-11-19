package de.javadevblog.mailclient.controller;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {
	
	public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
    private PasswordField pwfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    @FXML
    private TextField tfMailAdress;

    @FXML
    void loginBtnAction() {
    	System.out.println("login clicked!");
    	
    	viewFactory.showMainWindow();
    	Stage stage = (Stage)lblError.getScene().getWindow();
    	viewFactory.closeStage(stage);
    }

}
