package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {

    // ==========================
    // INIT JAVAFX
    // ==========================

    static {

        new JFXPanel();
    }

    // ==========================
    // ATTRIBUTES
    // ==========================

    private Store store;

    private Cart cart;

    // ==========================
    // CONSTRUCTOR
    // ==========================

    public StoreScreen(Store store, Cart cart) {

        this.store = store;

        this.cart = cart;

        Container cp = getContentPane();

        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);

        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");

        setSize(1024, 768);

        setLocationRelativeTo(null);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ==========================
    // NORTH
    // ==========================

    JPanel createNorth() {

        JPanel north = new JPanel();

        north.setLayout(
                new BoxLayout(north, BoxLayout.Y_AXIS)
        );

        north.add(createMenuBar());

        north.add(createHeader());

        return north;
    }

    // ==========================
    // MENU BAR
    // ==========================

    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore =
                new JMenu("Update Store");

        smUpdateStore.add(
                new JMenuItem("Add Book")
        );

        smUpdateStore.add(
                new JMenuItem("Add CD")
        );

        smUpdateStore.add(
                new JMenuItem("Add DVD")
        );

        menu.add(smUpdateStore);

        menu.add(
                new JMenuItem("View Store")
        );

        menu.add(
                new JMenuItem("View Cart")
        );

        JMenuBar menuBar = new JMenuBar();

        menuBar.setLayout(
                new FlowLayout(FlowLayout.LEFT)
        );

        menuBar.add(menu);

        return menuBar;
    }

    // ==========================
    // HEADER
    // ==========================

    JPanel createHeader() {

        JPanel header = new JPanel();

        header.setLayout(
                new BoxLayout(header, BoxLayout.X_AXIS)
        );

        JLabel title = new JLabel("AIMS");

        title.setFont(
                new Font(
                        title.getFont().getName(),
                        Font.PLAIN,
                        50
                )
        );

        title.setForeground(Color.CYAN);

        JButton cartButton =
                new JButton("View cart");

        cartButton.setPreferredSize(
                new Dimension(120, 50)
        );

        cartButton.setMaximumSize(
                new Dimension(120, 50)
        );

        // ==========================
        // OPEN CART SCREEN
        // ==========================

        cartButton.addActionListener(e -> {

            Platform.runLater(() -> {

                try {

                    new CartScreen(cart);

                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            });
        });

        header.add(
                Box.createRigidArea(
                        new Dimension(10, 10)
                )
        );

        header.add(title);

        header.add(Box.createHorizontalGlue());

        header.add(cartButton);

        header.add(
                Box.createRigidArea(
                        new Dimension(10, 10)
                )
        );

        return header;
    }

    // ==========================
    // CENTER
    // ==========================

    JPanel createCenter() {

        JPanel center = new JPanel();

        center.setLayout(
                new GridLayout(3, 3, 2, 2)
        );

        ArrayList<Media> mediaInStore =
                store.getItemsInStore();

        for (Media media : mediaInStore) {

            MediaStore cell =
                    new MediaStore(media, cart);

            center.add(cell);
        }

        return center;
    }

    // ==========================
    // MAIN
    // ==========================

    public static void main(String[] args) {

        Store store = new Store();

        Cart cart = new Cart();

        // DVD

        store.addMedia(
                new DigitalVideoDisc(
                        1,
                        "DVD 1",
                        "Action",
                        20.5f,
                        "Director A",
                        120
                )
        );

        // BOOK

        store.addMedia(
                new Book(
                        2,
                        "Java Book",
                        "Programming",
                        15.0f
                )
        );

        // CD

        store.addMedia(
                new CompactDisc(
                        3,
                        "Music CD",
                        "Pop",
                        18.0f,
                        "Producer A",
                        50,
                        "Artist A",
                        new ArrayList<>()
                )
        );

        // OPEN STORE SCREEN

        new StoreScreen(store, cart);
    }
}