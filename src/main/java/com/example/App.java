package com.example;

import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // ==========================
        // STEP 1: Create the layout
        // ==========================
        // TODO 1: Create and configure a GridPane
        // - Center align
        // - Add padding (12)
        // - Add horizontal and vertical gaps (5)
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(12));
        pane.setHgap(5);
        pane.setVgap(5);
       
        // ==========================
        // STEP 2: Add Labels and TextFields
        // ==========================
        // TODO 2: Add the following:
        // Label + TextField for:
        //     - Number
        //     - Description
        //     - Price
        
        Label lblPrompt = new Label("Enter product information:");
        pane.add(lblPrompt, 0, 0, 2, 1);

        Label lblNumber = new Label("Number:");
        TextField tfNumber = new TextField();
        pane.add(lblNumber, 0, 1);
        pane.add(tfNumber, 1, 1);

        Label lblname = new Label("Name:");
        TextField tfname = new TextField();
        pane.add(lblname, 0, 2);
        pane.add(tfname, 1, 2);

        Label lblPrice = new Label("Price:");
        TextField tfPrice = new TextField();
        pane.add(lblPrice, 0, 3);
        pane.add(tfPrice, 1, 3);

        // ==========================
        // STEP 3: Add Buttons
        // ==========================
        // TODO 3: Add two buttons: "Save" and "Quit" put the buttons at the bottom as shown on the lab diagram
        Button buttonQuit = new Button("Quit");
        Button buttonSave = new Button("Save");
        
        pane.add(buttonQuit, 0, 4);
        pane.add(buttonSave, 1, 4);
        // ==========================
        // STEP 4: Add Button Functionality using the setOnAction method
        
        // ==========================
        // (a) Save Button:
        //     - Collect input from text fields
        //     - Call writeToFile(text)
        //     - Clear all fields
        //
        // (b) Quit Button:
        //     - Exit application using Platform.exit()
        //
        // TODO 4a: Implement btSave.setOnAction(...)
        // TODO 4b: Implement btQuit.setOnAction(...)
        //
        buttonSave.setOnAction(e -> {
            String number = tfNumber.getText();
            String name = tfname.getText();
            String price = tfPrice.getText();
            
            String record = "Number: " + number + ", Name: " 
                    + name + ", Price: " + price + "\n";
            
            writeToFile(record);
            
            tfNumber.clear();
            tfname.clear();
            tfPrice.clear();
        });
        
        buttonQuit.setOnAction(e -> {
            Platform.exit();
        });
        
        // ==========================
        // STEP 5: Create and Show Scene
        // ==========================
        // TODO 5: Create a Scene, set the title, and display the stage
        Scene scene = new Scene(pane, 300, 220);
        stage.setTitle("Inventory Manager");
        stage.setScene(scene);
        stage.show();
    }

    // ==========================
    // STEP 6: Method for writing to file
    // ==========================
    // This method will handle opening, writing, and closing the file.
    // The file name should be "Products.txt".
    //
    // TODO 6: Implement file writing logic.
    private void writeToFile(String text) {
        try (FileWriter writer = new FileWriter("Products.txt", true)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}