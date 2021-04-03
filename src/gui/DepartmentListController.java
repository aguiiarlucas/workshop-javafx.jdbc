package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

//_________Criando a classe DepartmentListController_________
public class DepartmentListController implements Initializable {
	//__________Referencias para o DepartmentList_________
	 
		private DepartmentService  service;
		 
	
		@FXML
		private TableView<Department> tableViewDEpartment;
		
		@FXML
		private TableColumn<Department, Integer> tableColumnId;
		
		@FXML 
		private TableColumn<Department, String> tableColumnName;
		
		@FXML
		private Button btNew; 
		
		//__________Carregar os departamentos dentro do tableView_________
		private ObservableList<Department>obsList;
		
		@FXML
		public void  onButtonAction(ActionEvent event) { //tratamento de evento para clicar no botão
			Stage parentStage = Utils.currentStage(event);
			createDialogForm("/gui/DepartmentForm.fxml", parentStage);
		}

		public void setService(DepartmentService service) {
			this.service = service; // injeção de dependencia
		}
	 
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
	//_________Macete padrão para iniciar o comportamento das columnas_________
	
	private void initializeNodes() {
		 
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
	
	//__________Macete para o tableViewDepartment acompanhar a altura da janela_________
		
		Stage stage = (Stage)Main.getMainScene().getWindow(); //referencia para janela
		tableViewDEpartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	//_________Método responsável por acessar , carregar e  jogar os dep no ObsList;
	public void updateTableView() {
		//if de segurança ; esqueceu .
		 if(service == null) {
			 throw new  IllegalStateException(" Service was null ");
	}
		 List<Department>list = service.findAll();
		 obsList= FXCollections.observableArrayList(list); // pega os dados originais da lista
		 tableViewDEpartment.setItems(obsList);
	}
	
	private void createDialogForm(String absolutName,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			Pane pane = loader.load();
			
			//_________Função pra carregar a janela do formulario pra carregar um novo departamento
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Department daata"); // Config titulo da janela
			dialogStage.setScene(new Scene(pane)); //A Cena é o pane
			dialogStage.setResizable(false); //Janela pode ou não pode ser redimensionada
			dialogStage.initOwner(parentStage); //Pai da janela (?!)
			dialogStage.initModality(Modality.WINDOW_MODAL); //Se a janela é Model ou não (Travada)
			dialogStage.showAndWait(); //Mostra
		} catch (IOException e) {
			Alerts.showAlerts("IO Exception", "Error loading view", e.getMessage(),AlertType.ERROR);
		}
	}
}
