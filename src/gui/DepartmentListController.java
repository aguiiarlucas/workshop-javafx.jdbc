package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
		public void  onButtonAction() { //tratamento de evento para clicar no botão
			System.out.println("Foi clicado");
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
}
