package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered =
            FXCollections.observableArrayList();

    // ==========================
    // GET ITEMS
    // ==========================

    public ObservableList<Media> getItemsOrdered() {

        return itemsOrdered;
    }

    // ==========================
    // ADD MEDIA
    // ==========================

    public void addMedia(Media media) {

        // Cart đầy
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {

            throw new IllegalStateException(
                    "ERROR: Cart is full!"
            );
        }

        // Media null
        if (media == null) {

            throw new NullPointerException(
                    "ERROR: Media is null!"
            );
        }

        // Media đã tồn tại
        if (itemsOrdered.contains(media)) {

            System.out.println(
                    "The media already exists in cart."
            );

            return;
        }

        itemsOrdered.add(media);

        System.out.println(
                "The media has been added."
        );
    }

    // ==========================
    // REMOVE MEDIA
    // ==========================

    public void removeMedia(Media media) {

        if (media == null) {

            throw new NullPointerException(
                    "ERROR: Media is null!"
            );
        }

        if (itemsOrdered.contains(media)) {

            itemsOrdered.remove(media);

            System.out.println(
                    "The media has been removed."
            );

        } else {

            System.out.println(
                    "The media does not exist."
            );
        }
    }

    // ==========================
    // TOTAL COST
    // ==========================

    public float totalCost() {

        float total = 0;

        for (Media media : itemsOrdered) {

            total += media.getCost();
        }

        return total;
    }

    // ==========================
    // SORT BY TITLE
    // ==========================

    public void sortByTitle() {

        System.out.println(
                "Cart sorted by title."
        );
    }

    // ==========================
    // SORT BY COST
    // ==========================

    public void sortByCost() {

        System.out.println(
                "Cart sorted by cost."
        );
    }
}