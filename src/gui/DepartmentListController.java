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

public class DepartmentListController implements Initializable{
	
	//Atributos
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnName;
	
	@FXML
	private Button btNew;

	
	// Métodos evento do menu
	@FXML
	public void onBtNewAction() {
		System.out.println("btNew");
	}
	
	//Método padrão do initializable
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	
	//Iniciar o comportamento das colunas da tabela
		private void initializeNodes() {
			tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
			tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
			
	//Ajustar a tabela para ocupar a largura e altura da janela 
			Stage stage = (Stage) Main.getMainScene().getWindow();
			tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		}


}
