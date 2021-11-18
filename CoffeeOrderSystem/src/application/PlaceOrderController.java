package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;

public class PlaceOrderController {
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private TextField nameField;
	@FXML
	private RadioButton cappuccinoButton;
	@FXML
	private ToggleGroup toggleGroup1;
	@FXML
	private RadioButton latteButton;
	@FXML
	private RadioButton espressoButton;
	@FXML
	private RadioButton mochaButton;
	@FXML
	private RadioButton largeButton;
	@FXML
	private ToggleGroup toggleGroup2;
	@FXML
	private RadioButton mediumButton;
	@FXML
	private RadioButton smallButton;
	@FXML
	private RadioButton regularButton;
	@FXML
	private ToggleGroup toggleGroup3;
	@FXML
	private RadioButton decafButton;
	@FXML
	private Button clearButton;
	@FXML
	private Button placeOrderButton;
	
	private Stage orderSummaryStage;
	private OrderSummaryController orderSummaryController;
	
	@FXML
	public void clearButtonClick(ActionEvent event) {
		// Clear out text field and radio buttons
		nameField.clear();
		cappuccinoButton.setSelected(false);
		mochaButton.setSelected(false);
		espressoButton.setSelected(false);
		latteButton.setSelected(false);
		largeButton.setSelected(false);
		mediumButton.setSelected(false);
		smallButton.setSelected(false);
		regularButton.setSelected(false);
		decafButton.setSelected(false);
	}
	
	@FXML
	public void placeOrderButtonClick(ActionEvent event) {
		// initialize order string
		String order = "";
		
		// add size to string
		if (largeButton.isSelected()) {
			order += "Large ";
		}
		else if (mediumButton.isSelected()) {
			order += "Medium ";
		}
		else if (smallButton.isSelected()) {
			order += "Small ";
		}
		
		// add caffeinated to string
		if (regularButton.isSelected()) {
			order += "Regular ";
		}
		else if (decafButton.isSelected()) {
			order += "Decaf ";
		}
		
		// add drink type to string
		if (cappuccinoButton.isSelected()) {
			order += "Cappuccino";
		}
		else if (mochaButton.isSelected()) {
			order += "Mocha";
		}
		else if (espressoButton.isSelected()) {
			order += "Espresso";
		}
		else if (latteButton.isSelected()) {
			order += "Latte";
		}
		
		System.out.println(order);
		
		// If this is the first time in the button click, 
		// create the Order Summary window
		if (orderSummaryStage == null) {
			// get FXML loader and read in the FXML code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/OrderSummary.fxml"));
			AnchorPane orderSummaryRoot;
			
			try {
				// load orderSummary window and set controller to loader's controller
				orderSummaryRoot = (AnchorPane) loader.load();
				Scene orderSummaryScene = new Scene(orderSummaryRoot);
				orderSummaryStage = new Stage();
				orderSummaryStage.setScene(orderSummaryScene);
				orderSummaryController = (OrderSummaryController) loader.getController();
				
				// set calling controller in OrderSummaryController to self
				orderSummaryController.setCallingController(this);
				
				// set name and order labels
				orderSummaryController.setNameLabel(nameField.getText());
				orderSummaryController.setOrderLabel(order);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Show the window
		orderSummaryStage.show();
		System.out.println("After orderSummaryStage.show()");
		
		
	}
	
	// Clears order data 
	public void clearOrder() {
		// Clear out text field and radio buttons
		nameField.clear();
		cappuccinoButton.setSelected(false);
		mochaButton.setSelected(false);
		espressoButton.setSelected(false);
		latteButton.setSelected(false);
		largeButton.setSelected(false);
		mediumButton.setSelected(false);
		smallButton.setSelected(false);
		regularButton.setSelected(false);
		decafButton.setSelected(false);
	}

}
