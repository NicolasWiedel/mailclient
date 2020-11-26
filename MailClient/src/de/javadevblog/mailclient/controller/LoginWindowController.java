package de.javadevblog.mailclient.controller;

import java.net.URL;
import java.util.ResourceBundle;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.controller.services.LoginService;
import de.javadevblog.mailclient.model.EmailAccount;
import de.javadevblog.mailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController implements Initializable {
	
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
    	if(fieldsAreValid()) {
    		EmailAccount emailAccount = new EmailAccount(tfMailAdress.getText(), pwfPassword.getText());
    		LoginService loginService = new LoginService(emailAccount, emailManager);
    		loginService.start();
    		loginService.setOnSucceeded(event -> {
    			EmailLoginReult emailLoginResult = loginService.getValue();
        		
        		switch (emailLoginResult) {
    			case SUCCESS: 
    				System.out.println("login successful!!!!" + emailAccount);
    				viewFactory.showMainWindow();
    		    	Stage stage = (Stage)lblError.getScene().getWindow();
    		    	viewFactory.closeStage(stage);
    				return;
    			case FAILED_BY_CREDENTIALS:
    				lblError.setText("unexpected error!");
    				return;
    			case FAILED_BY_UNEXPECTED_ERROR:
    				lblError.setText("unexpected error!");
    				return;
    			default:
    				throw new IllegalArgumentException("Unexpected value: " + emailLoginResult);
    			}
    		});	
    	}	
    }

	private boolean fieldsAreValid() {
		if(tfMailAdress.getText().isEmpty()) {
			lblError.setText("Bitte geben Sie eine gültige Maladresse ein!");
			return false;
		}
		if(pwfPassword.getText().isEmpty()) {
			lblError.setText("Bitte geben Sie ein gültiges Passwort ein!");
			return false;
		}
		return true;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}