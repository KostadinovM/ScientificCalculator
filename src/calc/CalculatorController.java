package calc;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Class that combines the button interaction with the calculator logic.
 * 
 * @author Martin Kostadinov
 *
 */
public class CalculatorController implements Initializable
{
	
	
	@FXML
    private Text output;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;
  
    private Calculator model = new Calculator();
    
    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private void processMemoryFunctions(ActionEvent event)
    {
    	
    	String value = ((Button)event.getSource()).getText();
    	if(value.equals("MC") && value.equals("MR"))
    		model.operateMemory(value);
    	else
    	{
    		long current = Long.parseLong(output.getText());
    		output.setText(String.valueOf(model.operateMemory(value, current)));
    	}
    	
    }
    

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		try {
			VBox box = FXMLLoader.load(getClass().getResource("NavigationDrawer.fxml"));
		
		
		drawer.setSidePane(box);
		drawer.setMouseTransparent(true);
		HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
		burgerTask.setRate(-1);
			hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
				burgerTask.setRate(burgerTask.getRate() * -1);
				burgerTask.play();
				
				if(drawer.isShown())
				{
					drawer.close();
					drawer.setMouseTransparent(true);
				}
				else
				{
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
