package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.transformation.FilteredList;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import hust.soict.dsai.aims.exception.PlayerException;

import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;

    private FilteredList<Media> filteredMedia;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label labelTotalCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController() {

    }

    @FXML
    public void initialize() {

        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<>("title")
        );

        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );

        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<>("cost")
        );

        btnPlay.setVisible(false);

        btnRemove.setVisible(false);

        tblMedia.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        new ChangeListener<Media>() {

                            @Override
                            public void changed(
                                    ObservableValue<? extends Media> observable,
                                    Media oldValue,
                                    Media newValue
                            ) {

                                if (newValue != null) {

                                    updateButtonBar(newValue);
                                }
                            }
                        }
                );

        tfFilter.textProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {

                            if (filteredMedia != null) {

                                showFilteredMedia(newValue);
                            }
                        }
                );
    }

    public void setCart(Cart cart) {

        this.cart = cart;

        filteredMedia =
                new FilteredList<>(
                        cart.getItemsOrdered(),
                        e -> true
                );

        tblMedia.setItems(filteredMedia);

        labelTotalCost.setText(
                String.format("%.2f $", cart.totalCost())
        );
    }

    public void showFilteredMedia(String filter) {

        filteredMedia.setPredicate(media -> {

            if (filter == null || filter.isEmpty()) {

                return true;
            }

            if (radioBtnFilterId.isSelected()) {

                return String.valueOf(media.getId())
                        .contains(filter);
            }

            if (radioBtnFilterTitle.isSelected()) {

                return media.getTitle()
                        .toLowerCase()
                        .contains(filter.toLowerCase());
            }

            return true;
        });
    }

    void updateButtonBar(Media media) {

        btnRemove.setVisible(true);

        if (media instanceof Playable) {

            btnPlay.setVisible(true);

        } else {

            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media != null) {

            cart.removeMedia(media);

            labelTotalCost.setText(
                    String.format("%.2f $", cart.totalCost())
            );
        }
    }

    @FXML
    void btnPlayPressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media instanceof Playable) {

        	try {

        	    ((Playable) media).play();

        	} catch (PlayerException e) {

        	    Alert alert =
        	            new Alert(Alert.AlertType.ERROR);

        	    alert.setTitle("Player Error");

        	    alert.setHeaderText(null);

        	    alert.setContentText(
        	            e.getMessage()
        	    );

        	    alert.showAndWait();
        	}
        }
    }

    @FXML
    void btnPlaceOrderPressed() {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Order");

        alert.setHeaderText(null);

        alert.setContentText(
                "Order placed successfully!"
        );

        alert.showAndWait();
    }
}