module Project04JavaFX {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
