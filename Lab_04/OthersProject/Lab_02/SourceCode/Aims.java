package Teddy;

public class Aims {
    public static void main(String[] args) {
        
        // Create a new cart
        Cart anOrder = new Cart();
        
        // Create new dvd objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.95f
        );
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                "John Musker",
                90,
                18.99f
        );
        
        // Add DVDs to cart
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        
        // Print total cost
        System.out.println("Total cost is: " + anOrder.totalCost());
        
        // Remove a DVD
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // Print total cost again
        System.out.println("Total cost after removal is: " + anOrder.totalCost());
    }
}