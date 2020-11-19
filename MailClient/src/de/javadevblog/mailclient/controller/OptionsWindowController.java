package de.javadevblog.mailclient.controller;

import java.net.URL;
import java.util.ResourceBundle;

import de.javadevblog.mailclient.EmailManager;
import de.javadevblog.mailclient.view.ColorTheme;
import de.javadevblog.mailclient.view.FontSize;
import de.javadevblog.mailclient.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

public class OptionsWindowController extends BaseController implements Initializable {

	public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
		super(emailManager, viewFactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

	@FXML
    private Slider sliderFontSize;

    @FXML
    private ChoiceBox<ColorTheme> cbThemePicker;

    @FXML
    void btnApplyAction() {

    }

    @FXML
    void btnCancelAction() {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setUpThemePicker();
		setUpFontSizeSlider();
	}

	private void setUpFontSizeSlider() {
		sliderFontSize.setMin(0);
		sliderFontSize.setMax(FontSize.values().length - 1);
		sliderFontSize.setValue(viewFactory.getFontSize().ordinal());
		sliderFontSize.setMajorTickUnit(1);
		sliderFontSize.setMinorTickCount(0);
		sliderFontSize.setBlockIncrement(1);
		sliderFontSize.setSnapToTicks(true);
		sliderFontSize.setShowTickMarks(true);
		sliderFontSize.setShowTickLabels(true);
		sliderFontSize.setLabelFormatter(new StringConverter<Double>() {
			@Override
			public String toString(Double object) {
				int i = object.intValue();
				return FontSize.values()[i].toString();
			}
			
			@Override
			public Double fromString(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		sliderFontSize.valueProperty().addListener((obs, oldVal, newVal) -> {
			sliderFontSize.setValue(newVal.intValue());
		});
	}

	private void setUpThemePicker() {
		cbThemePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
		cbThemePicker.setValue(viewFactory.getColorTheme());
	}

}
