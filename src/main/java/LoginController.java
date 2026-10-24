
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private final ArrayList<User> users = UsersApp.loadUsers();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        for (User user : users) {
            if (user.getName().equals(username)
                    && user.getPassword().equals(password)) {

                openWelcomeScreen();
                return;
            }
        }

        errorLabel.setText("Invalid username or password");
    }

    private void openWelcomeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Welcome.fxml")
            );

            Stage stage = (Stage) usernameField
                    .getScene().getWindow();

            stage.setScene(new Scene(loader.load()));
            stage.setTitle("GCM Welcome");

        } catch (IOException e) {
            errorLabel.setText("Could not open Welcome screen");
            e.printStackTrace();
        }
    }
}
