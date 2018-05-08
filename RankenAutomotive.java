package hot10_11;

import org.omg.CORBA.DynAnyPackage.Invalid;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RankenAutomotive extends Application {

	private double total;
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Ranken's Automotive Maintenance");
		CheckBox oil = new CheckBox("Oil Change ($26.00)");
		CheckBox lube = new CheckBox("Lube Job ($18.00)");
		CheckBox radiator = new CheckBox("Radiator Flush ($30.00)");
		CheckBox transmisson = new CheckBox("Transmission Flush ($80.00)");
		CheckBox inspection = new CheckBox("Inspection ($15.00)");
		CheckBox muffler = new CheckBox("Muffler replacement ($100.00)");
		CheckBox tire = new CheckBox("Tire rotation ($20.00)");
		Label partsLbl = new Label("Parts Charges:");
		Label hoursLbl = new Label("Hours of Labor:");
		TextField partsTf = new TextField("0");
		TextField hoursTf = new TextField("0");
		Button calculate = new Button("Calculate Charges");
		Button exit = new Button("Exit");
		Label resultLbl = new Label();
		
		VBox labelsVbox = new VBox(10,partsLbl, hoursLbl);
		VBox textFieldVbox = new VBox(partsTf, hoursTf);
		//HBox partsHbox = new HBox(40, partsLbl, partsTf);
		//partsHbox.setAlignment(Pos.CENTER);
//		HBox hoursHbox = new HBox(40, hoursLbl, hoursTf);
//		hoursHbox.setAlignment(Pos.CENTER);
		HBox buttonHbox = new HBox(5, calculate, exit);
		buttonHbox.setAlignment(Pos.CENTER);
		GridPane root = new GridPane();
		root.add(oil, 0, 0);
		root.add(lube, 0, 1);
		root.add(radiator, 0, 2);
		root.add(transmisson, 0, 3);
		root.add(inspection, 0, 4);
		root.add(muffler, 0, 5);
		root.add(tire, 0, 6);
		root.add(labelsVbox, 0, 7);
		root.add(textFieldVbox, 1, 7);
		root.add(buttonHbox, 0, 9);
		root.add(resultLbl, 0, 10);
		
		root.setVgap(10);
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		calculate.setOnAction(e -> 
		{
			total = 0;
			double partsCharge;
			double numHours;
			
			if(oil.isSelected())
			{
				total += 26.00;
			}
			if(lube.isSelected())
			{
				total += 18.00;
			}
			if(radiator.isSelected())
			{
				total += 30.00;
			}
			if(transmisson.isSelected())
			{
				total += 80.00;
			}
			if(inspection.isSelected())
			{
				total += 15.00;
			}
			if(muffler.isSelected())
			{
				total += 100.00;
			}
			if(tire.isSelected())
			{
				total += 20.00;
			}
			
			try
			{
				partsCharge = Double.parseDouble(partsTf.getText());
				numHours = Double.parseDouble(hoursTf.getText());
				
				total += partsCharge;
				total += (numHours * 20);
				resultLbl.setText(String.format("Total $%,.2f", total));
			}
			catch (NumberFormatException ex) 
			{
				resultLbl.setText("Invalid entry, please fix error");
			}
			catch (Exception ex2) 
			{
				resultLbl.setText("Invalid entry, please fix error");
			}
		});
		
		exit.setOnAction(e2 -> 
		{
			primaryStage.close();
		});
	}

}
