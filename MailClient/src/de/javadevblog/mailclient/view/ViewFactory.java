package de.javadevblog.mailclient.view;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.controller.BaseController;
import de.javadevblog.mailclient.controller.LoginWindowController;
import de.javadevblog.mailclient.controller.MainWindowController;
import de.javadevblog.mailclient.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {

	private EmailManager emailManager;
	
	// View options handling
	private ColorTheme colorTheme = ColorTheme.DEFAULT;
	private FontSize fontSize = FontSize.MEDIUM;

	public ViewFactory(EmailManager emailManager) {
		this.emailManager = emailManager;
	}
	
	public void showLoginWindow() {
		
		BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
		initializeStage(controller);
	}
	
	public void showMainWindow() {
		
		BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
		initializeStage(controller);
	}
	
	public void showOptionsWindow() {
		
		BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
		initializeStage(controller);
	}
	
	private void initializeStage(BaseController controller) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
		fxmlLoader.setController(controller);
		Parent parent;
		try {
			parent = fxmlLoader.load();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		if(controller.getFxmlName() == "LoginWindow.fxml"){
			stage.setTitle("Login");
			stage.setResizable(false);
		}
		else if(controller.getFxmlName() == "MainWindow.fxml"){
			stage.setTitle("Email-Client");
			stage.setResizable(true);
		}
		else if(controller.getFxmlName() == "OptionsWindow.fxml"){
			stage.setTitle("Optionen");
			stage.setResizable(false);
		}
		stage.show();
	}
	
	public void closeStage(Stage stageToClose) {
		stageToClose.close();
	}

	public ColorTheme getColorTheme() {
		return colorTheme;
	}

	public void setColorTheme(ColorTheme colorTheme) {
		this.colorTheme = colorTheme;
	}

	public FontSize getFontSize() {
		return fontSize;
	}

	public void setFontSize(FontSize fontSize) {
		this.fontSize = fontSize;
	}
	
	
}
