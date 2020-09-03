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

public class DepartmentListController implements Initializable{
	
	//Dependência
	private DepartmentService service;
	
	
	//Atributos
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;

	
	// Métodos evento do menu
	@FXML
	public void onBtNewAction() {
		System.out.println("btNew");
	}
	
	//Método de acesso
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
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
		
	//Métodos
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.fintAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}
}
