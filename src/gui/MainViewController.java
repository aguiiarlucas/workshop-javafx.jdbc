package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

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
		loadView("/gui/DepartmentList.fxml",(DepartmentListController controller)->{
			controller.setService(new DepartmentService());
			controller.updateTableView();
		});
		}
	@FXML
	public void menuItemAboutAction() {
		loadView("/gui/About.fxml",x->{});
	}

	@Override
	public synchronized void initialize(URL uri, ResourceBundle rb) {
 
	}
	//__________Criando uma fun��o generica pra abrir outra tela (LoadView)__________
	
	private  synchronized <T>  void loadView(String absolutName, Consumer<T>initializingAction ) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load(); //carrega a view
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();//limpa todos os filhos do vbox
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			//__________Comando para executar onMenuItemSellerACtion__________
			
			T controller  = loader.getController();
			initializingAction.accept(controller);
		} catch (IOException e) {
			Alerts.showAlerts("IO Exception", "Error loading view", e.getMessage(),AlertType.ERROR);
		}
	
	}
 
}
