package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	
	//Atributos 
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuAbout;

	
	
	//M�todos evento do menu
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSeller");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartment");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("About");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	}
}
