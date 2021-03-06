package fancy4.taskie.view;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
//import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import fancy4.taskie.MainApp;
import fancy4.taskie.model.TaskieLogic;


public class TaskieOverviewController {
	@FXML
	private TableView<String> mainTaskTable;
	@FXML
	private TableColumn<String, String> taskColumn;
	@FXML
	private TableView<String> dTaskTable;
	@FXML
	private TableColumn<String, String> dTaskColumn;
	@FXML
	private TableView<String> fTaskTable;
	@FXML
	private TableColumn<String, String> fTaskColumn;

	@FXML
	private TextField textInput;
	@FXML
	private TextArea textOutput;

	private MainApp mainApp;

    private String textOutputResponse = "";
    
	public TaskieOverviewController() {

	}

	@FXML
	private void initialize() {
		TaskieLogic.initialise();
		iniColumn(taskColumn);
		iniColumn(dTaskColumn);
		iniColumn(fTaskColumn);
		
	}
	
	private void iniColumn(TableColumn<String, String> column) {
		TaskieLogic.initialise();
		column.setCellValueFactory(new Callback<CellDataFeatures<String, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<String, String> p) {
				return new SimpleStringProperty(p.getValue());
			}
		});
	}


	public void inputEnter(KeyEvent event) {
		String input;
		if (event.getCode() == KeyCode.ENTER) {
			input = textInput.getText();
			
			String[][] fromLogic = TaskieLogic.execute(input);
			String[] mainData, dData, fData;
			/*mainData = new String[]{"m1","m2","m3","m4","m5",};
			dData = new String[]{"d1","d2","d3","d4","d5",};
			fData = new String[]{"f1","f2","f3","f4","f5",};
			String response = "response";*/
			mainData = fromLogic[1];
			dData = fromLogic[2];
			fData = fromLogic[3];
			String response =  fromLogic[0][1];
			
			updateMainTable(mainData);
			updateDTable(dData);
			updateFTable(fData);
			
			textOutputResponse += "input: " + input + "\n" + "response: " + response + "\n";
			textOutput.setText(textOutputResponse);


			textInput.clear();
		}

	}
	public void updateMainTable(String[] data) {
		
		if (data == null) {	
			
		} else {
			mainTaskTable.getItems().removeAll(mainApp.getTaskData());
			mainTaskTable.getItems().addAll(data);
		}
	}
	public void updateDTable(String[] data) {
		
		if (data == null) {	
	
			
		} else {
			dTaskTable.getItems().removeAll(mainApp.getDTaskData());
			dTaskTable.getItems().addAll(data);
		}
	}

	public void updateFTable(String[] data) {
		
		if (data == null) {	
			
		} else {
			fTaskTable.getItems().removeAll(mainApp.getFTaskData());
			fTaskTable.getItems().addAll(data);
		}
	}






	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		mainTaskTable.setItems(mainApp.getTaskData());
		dTaskTable.setItems(mainApp.getDTaskData());
		fTaskTable.setItems(mainApp.getFTaskData());
	}
}
