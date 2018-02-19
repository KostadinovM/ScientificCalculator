package calc;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DrawerController
{
	private Calculator model = new Calculator();

	@FXML
	private JFXHamburger hamburger;

	@FXML
	private JFXDrawer drawer;

	public void init(JFXDrawer drawer, JFXHamburger hamburger)
	{
		
		try {
			VBox box = FXMLLoader.load(getClass().getResource("/views/NavigationDrawer.fxml"));

			drawer.setSidePane(box);
			drawer.setMouseTransparent(true);

			for (Node node : box.getChildren()) {
				node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
					Stage stage = null;
					Parent root = null;
					if (node.getAccessibleText() != null) {
						switch (node.getAccessibleText())
						{
						case "Integrals":
							try {
								stage = (Stage) drawer.getScene().getWindow();
								root = FXMLLoader.load(getClass().getResource("/views/CalculatorViewIntegral.fxml"));
							}
							catch (Exception e1) {
								e1.printStackTrace();
							}

							break;
						case "Standard":
							try {
								stage = (Stage) drawer.getScene().getWindow();
								root = FXMLLoader.load(getClass().getResource("/views/CalculatorViewStandard.fxml"));
							}
							catch (Exception e1) {
								e1.printStackTrace();
							}

							break;
						}
						
					}
					stage.setTitle("Calculator");
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				});
				
			}
			

			HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
			burgerTask.setRate(-1);
			hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
				burgerTask.setRate(burgerTask.getRate() * -1);
				burgerTask.play();

				if (drawer.isShown()) {
					drawer.close();
					drawer.setMouseTransparent(true);
				}
				else {
					drawer.open();
					drawer.setMouseTransparent(false);
				}
			});
			drawer.disabledProperty();
		}
		catch (IOException e1) {
		}
	}

}
