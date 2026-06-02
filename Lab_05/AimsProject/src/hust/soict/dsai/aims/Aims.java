package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== CREATE STORE =====
        Store store = new Store();

        // ===== CREATE CART =====
        Cart cart = new Cart();

        // ===== CREATE SAMPLE MEDIAS =====

        // Book
        Book book = new Book(
                1,
                "Java Programming",
                "Technology",
                45.5f
        );

        book.addAuthor("James Gosling");

        // DVD
        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        2,
                        "Inception",
                        "Sci-Fi",
                        24.99f,
                        "Christopher Nolan",
                        148
                );

        // CD
        ArrayList<Track> tracks =
                new ArrayList<Track>();

        CompactDisc cd =
                new CompactDisc(
                        3,
                        "Abbey Road",
                        "Rock",
                        19.99f,
                        "George Martin",
                        47,
                        "The Beatles",
                        tracks
                );

        cd.addTrack(
                new Track("Come Together", 255)
        );

        cd.addTrack(
                new Track("Something", 182)
        );

        // ===== ADD MEDIAS TO STORE =====

        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(cd);

        // ===== MAIN PROGRAM =====

        int choice;

        do {

            showMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ===== VIEW STORE =====
                case 1:

                    System.out.println("\nSTORE ITEMS:");

                    System.out.println(book);
                    System.out.println(dvd);
                    System.out.println(cd);

                    storeMenu();

                    int storeChoice =
                            scanner.nextInt();

                    scanner.nextLine();

                    switch (storeChoice) {

                        // ===== SEE MEDIA DETAILS =====
                        case 1:

                            System.out.print(
                                    "Enter media title: "
                            );

                            String detailTitle =
                                    scanner.nextLine();

                            Media foundMedia = null;

                            if (book.getTitle()
                                    .equalsIgnoreCase(detailTitle)) {

                                foundMedia = book;

                            } else if (dvd.getTitle()
                                    .equalsIgnoreCase(detailTitle)) {

                                foundMedia = dvd;

                            } else if (cd.getTitle()
                                    .equalsIgnoreCase(detailTitle)) {

                                foundMedia = cd;
                            }

                            if (foundMedia != null) {

                                System.out.println(
                                        foundMedia.toString()
                                );

                                mediaDetailsMenu();

                            } else {

                                System.out.println(
                                        "Media not found!"
                                );
                            }

                            break;

                        // ===== ADD MEDIA TO CART =====
                        case 2:

                            System.out.print(
                                    "Enter media title: "
                            );

                            String addTitle =
                                    scanner.nextLine();

                            if (book.getTitle()
                                    .equalsIgnoreCase(addTitle)) {

                                cart.addMedia(book);

                            } else if (dvd.getTitle()
                                    .equalsIgnoreCase(addTitle)) {

                                cart.addMedia(dvd);

                            } else if (cd.getTitle()
                                    .equalsIgnoreCase(addTitle)) {

                                cart.addMedia(cd);

                            } else {

                                System.out.println(
                                        "Media not found!"
                                );
                            }

                            break;

                        // ===== PLAY MEDIA =====
                        case 3:

                            System.out.print(
                                    "Enter media title: "
                            );

                            String playTitle =
                                    scanner.nextLine();

                            Media mediaToPlay = null;

                            if (book.getTitle()
                                    .equalsIgnoreCase(playTitle)) {

                                mediaToPlay = book;

                            } else if (dvd.getTitle()
                                    .equalsIgnoreCase(playTitle)) {

                                mediaToPlay = dvd;

                            } else if (cd.getTitle()
                                    .equalsIgnoreCase(playTitle)) {

                                mediaToPlay = cd;
                            }

                            if (mediaToPlay != null) {

                                if (mediaToPlay
                                        instanceof Playable) {

                                    ((Playable) mediaToPlay)
                                            .play();

                                } else {

                                    System.out.println(
                                            "This media cannot be played!"
                                    );
                                }

                            } else {

                                System.out.println(
                                        "Media not found!"
                                );
                            }

                            break;

                        // ===== SEE CURRENT CART =====
                        case 4:

                            System.out.println(
                                    "Current cart total cost: "
                                            + cart.totalCost()
                                            + " $"
                            );

                            break;

                        case 0:
                            break;

                        default:

                            System.out.println(
                                    "Invalid option!"
                            );
                    }

                    break;

                // ===== UPDATE STORE =====
                case 2:

                    System.out.println(
                            "Update store feature"
                    );

                    break;

                // ===== SEE CURRENT CART =====
                case 3:

                    cartMenu();

                    int cartChoice =
                            scanner.nextInt();

                    scanner.nextLine();

                    switch (cartChoice) {

                        // ===== SORT BY TITLE =====
                        case 1:

                            cart.sortByTitle();

                            break;

                        // ===== SORT BY COST =====
                        case 2:

                            cart.sortByCost();

                            break;

                        // ===== REMOVE MEDIA =====
                        case 3:

                            System.out.print(
                                    "Enter title to remove: "
                            );

                            String removeTitle =
                                    scanner.nextLine();

                            if (book.getTitle()
                                    .equalsIgnoreCase(removeTitle)) {

                                cart.removeMedia(book);

                            } else if (dvd.getTitle()
                                    .equalsIgnoreCase(removeTitle)) {

                                cart.removeMedia(dvd);

                            } else if (cd.getTitle()
                                    .equalsIgnoreCase(removeTitle)) {

                                cart.removeMedia(cd);

                            } else {

                                System.out.println(
                                        "Media not found!"
                                );
                            }

                            break;

                        // ===== PLAY MEDIA =====
                        case 4:

                            System.out.print(
                                    "Enter media title: "
                            );

                            String cartPlayTitle =
                                    scanner.nextLine();

                            if (dvd.getTitle()
                                    .equalsIgnoreCase(cartPlayTitle)) {

                                dvd.play();

                            } else if (cd.getTitle()
                                    .equalsIgnoreCase(cartPlayTitle)) {

                                cd.play();

                            } else {

                                System.out.println(
                                        "Media cannot be played!"
                                );
                            }

                            break;

                        // ===== PLACE ORDER =====
                        case 5:

                            System.out.println(
                                    "Order created successfully!"
                            );

                            break;

                        case 0:
                            break;

                        default:

                            System.out.println(
                                    "Invalid option!"
                            );
                    }

                    break;

                // ===== EXIT =====
                case 0:

                    System.out.println(
                            "Goodbye!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 0);

        scanner.close();
    }

    // ===== MAIN MENU =====

    public static void showMenu() {

        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    // ===== STORE MENU =====

    public static void storeMenu() {

        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    // ===== MEDIA DETAILS MENU =====

    public static void mediaDetailsMenu() {

        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    // ===== CART MENU =====

    public static void cartMenu() {

        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort medias by title");
        System.out.println("2. Sort medias by cost");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}