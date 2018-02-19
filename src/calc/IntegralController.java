package calc;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class IntegralController implements Initializable
{

	private int a = 0;
	private int b = 0;
	private double exp1=0;
	private double res1 = 0;

	private Calculator model = new Calculator();

	@FXML
	private Button calculationButton;

	@FXML
	private JFXHamburger hamburger;

	@FXML
	private JFXDrawer drawer;

	@FXML
	private TextArea fromBox;

	@FXML
	private TextArea toBox;

	@FXML
	private Button calculateButton;

	@FXML
	private TextArea box1;


	@FXML
	private TextArea sign1;


	@FXML
	private TextArea resultBox;

	@FXML
    void calc(ActionEvent event) {
    	a = Integer.parseInt(fromBox.getText());
    	b = Integer.parseInt(toBox.getText());

    	
    	if ((box1.getText().trim().length() > 0))
    		exp1 = Double.parseDouble(box1.getText());
    	
    
    	switch(sign1.getText())
    	{
    	case "+": 
    		res1=model.integral(a, b, x->{
    			return exp1 + x;
    		});
    		break;
    	case "-": 
    		res1=model.integral(a, b, x->{
    			return exp1 - x;
    		});
    		break;
    	case "*": 
    		res1=model.integral(a, b, x->{
    			return exp1 * x;
    		});
    		break;
    	case "/": 
    		res1=model.integral(a, b, x->{
    			return exp1 / x;
    		});
    		break;
    	}

 
    	resultBox.setText(res1 + " ");
    	box1.clear();
    	sign1.clear();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		DrawerController dc = new DrawerController();
		dc.init(drawer, hamburger);

	}

}
