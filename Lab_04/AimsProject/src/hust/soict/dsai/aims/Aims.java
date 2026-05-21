package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        
        // Create a new cart
        Cart anOrder = new Cart();
        
        // Create new dvd objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
        		1, 
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                2,
        		"Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.95f
        );
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                3,
        		"Aladdin",
                "Animation",
                "John Musker",
                90,
                18.99f
        );
        
        // Add DVDs to cart
        anOrder.addMedia(dvd1);
        anOrder.addMedia(dvd2);
        anOrder.addMedia(dvd3);
        
        // Print total cost
        System.out.println("Total cost is: " + anOrder.totalCost());
        
        // Remove a DVD
        anOrder.removeMedia(dvd2);
        
        // Print total cost again
        System.out.println("Total cost after removal is: " + anOrder.totalCost());
        
        /*
        DigitalVideoDisc[] list = {dvd1, dvd2, dvd3};
        anOrder.addMedia(list);
        
        anOrder.addMedia(dvd1, dvd2);
        */
    }
}