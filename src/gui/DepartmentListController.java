package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

//_________Criando a classe DepartmentListController_________
public class DepartmentListController implements Initializable {
	//__________Referencias para o DepartmentList_________
	
		@FXML
		private TableView<Department> tableViewDEpartment;
		
		@FXML
		private TableColumn<Department, Integer> tableColumnId;
		
		@FXML 
		private TableColumn<Department, String> tableColumnName;
		
		@FXML
		private Button btNew; 
		
		@FXML
		public void  onButtonAction() { //tratamento de evento para clicar no botão
			System.out.println("Foi clicado");
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

}
