
package gui.util;

import java.awt.TextField;

public class Constraints {

	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue)->{
			if(newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	
	}
	public static void setTextFieldMaxLenght(TextField txt,int max ) {
		txt.textProperty().addListener((obs,oldValue,newValue) -> {
			if(newValue !=null && newValue.length()> max ) {
				txt.setText(oldValue);
			}
		});
	}
	
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs,oldValue,newValue)->{
			if(newValue != null && newValue.matches("\\d*([\\.]\\d*)?")){
				txt.setText(oldValue);
			}
		});
	}
}