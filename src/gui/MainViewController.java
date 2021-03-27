package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	//__________ Criando o controller da janela principal __________
			  // ______Criando os itens da janela______
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void menuItemDepartmentAction() {
		System.out.println("menuItemDepartmentAction");
	}
	
	@FXML
	public void menuItemAboutAction() {
		System.out.println("menuItemAboutAction");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
		
		
	}
	
	
	
	

}
