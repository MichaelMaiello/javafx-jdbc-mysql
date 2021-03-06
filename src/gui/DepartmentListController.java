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

public class DepartmentListController implements Initializable{
	
	//Depend�ncia
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

	
	// M�todos evento do menu
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		createDialoForm("/gui/DepartmentForm.fxml", parentStage);
	}
	
	//M�todo de acesso
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	
	//M�todo padr�o do initializable
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
		
	//M�todos
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.fintAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}
	
	private void createDialoForm(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			//Abrir janela de dialogo
			Stage dialoStage = new Stage();
			dialoStage.setTitle("Enter Department data");
			dialoStage.setScene(new Scene(pane));
			dialoStage.setResizable(false);
			dialoStage.initOwner(parentStage);
			dialoStage.initModality(Modality.WINDOW_MODAL);
			dialoStage.showAndWait();
			
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro loadiag view", e.getMessage(), AlertType.ERROR);
		}
		
	}
}
