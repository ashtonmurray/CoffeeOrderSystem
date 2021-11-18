package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

public class OrderSummaryController {
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Label nameLabel;
	@FXML
	private Label orderLabel;
	@FXML
	private Button cancelButton;
	@FXML
	private Button confirmButton;
	
	private PlaceOrderController callingController;

	// Public methods to set name and order labels
	public void setNameLabel(String name) {
		nameLabel.setText(name);
	}
	
	public void setOrderLabel(String order) {
		orderLabel.setText(order);
	}
	
	// Setting PlaceOrderController
	public void setCallingController(PlaceOrderController c) {
		callingController = c;
	}
	
	// cancel order, close window, and clear all data on PlaceOrder page
	@FXML
	public void cancelButtonClick(ActionEvent event) {
		callingController.clearOrder();
		anchorPane.getScene().getWindow().hide();
	}
	
	// close window and return to PlaceOrder page (data still remains)
	@FXML
	public void confirmButtonClick(ActionEvent event) {
		anchorPane.getScene().getWindow().hide();
	}
}
