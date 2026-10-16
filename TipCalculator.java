import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipCalculator extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("Tip Calculator");

        TextField billField = new TextField();
        billField.setPromptText("Enter Bill Amount");

        TextField tipField = new TextField();
        tipField.setPromptText("Enter Tip Percentage");

        Button calculateButton = new Button("Calculate Tip");
        Label resultLabel = new Label();

        calculateButton.setOnAction(e -> {
            try {
                double bill = Double.parseDouble(billField.getText());
                double tipPercent = Double.parseDouble(tipField.getText());

                if (bill < 0 || tipPercent < 0) {
                    resultLabel.setText("Enter positive values.");
                    return;
                }

                double tip = bill * tipPercent / 100;
                double total = bill + tip;

                resultLabel.setText(String.format(
                    "Tip Amount: %.2f%nTotal Amount: %.2f",
                    tip, total
                ));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        VBox root = new VBox(12, title, billField, tipField,
                             calculateButton, resultLabel);
        root.setPadding(new Insets(20));

        stage.setTitle("Tip Calculator");
        stage.setScene(new Scene(root, 350, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
