package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	public static Stage currentStage(ActionEvent event) {
		return (Stage)((Node)event.getSource()).getScene().getWindow();
		
	}
	public static Integer  tryParseToInt(String str) {
		try {
			return Integer.parseInt(str); //converter String para Int , se houver um erro...
			
		} catch (NumberFormatException e) {
			return null;// ... ele retorna null(vazio)
		}
	}
}
