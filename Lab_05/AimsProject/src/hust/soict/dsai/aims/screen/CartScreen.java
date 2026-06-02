package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen {

    public CartScreen(Cart cart) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("cart.fxml")
                    );

            Parent root = loader.load();

            CartScreenController controller =
                    loader.getController();

            controller.setCart(cart);

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setTitle("Cart");

            stage.setScene(scene);

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}