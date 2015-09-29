package fancy4.taskie.view;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
	private TableColumn<String, String> indexColumn;
	@FXML
	private TableColumn<String, String> taskColumn;
	@FXML
	private TableColumn<String, String> priorityColumn;

	@FXML
	private TextField textInput;
	@FXML
	private TextArea textOutput;
	private MainApp mainApp;
	


	public TaskieOverviewController() {

	}

	@FXML
	private void initialize() {
		/*for (int i = 0; i < 100; i++) {
			if (i > 40) {
				MainApp.refresh();
			}
		}*/
		TaskieLogic.initialize();
		taskColumn.setCellValueFactory(new Callback<CellDataFeatures<String, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<String, String> p) {
				return new SimpleStringProperty(p.getValue());
			}
		});
	}
	
	public void inputEnter(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			TaskieLogic.execute(textInput.getText());
			textInput.clear();
		}
		MainApp.taskData.removeAll();
	}
	
	


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		mainTaskTable.setItems(mainApp.getTaskData());
	}
}
