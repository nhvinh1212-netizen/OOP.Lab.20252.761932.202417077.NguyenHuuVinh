package hust.soict.dsai.aims.store;

//import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;


public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	//private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
	//private int qtyInStore = 0;
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("The DVD has been added to the store");
	}
	
	public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The item '" + media.getTitle() + "' has been successfully removed from the store.");
        } else {
            System.out.println("The item '" + media.getTitle() + "' was not found in the store.");
        }
    }
	
	/*
	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyInStore < MAX_ITEMS_IN_STORE) {
			itemsInStore[qtyInStore] = dvd;
			qtyInStore++;
			System.out.println("The DVD has been added to the store");
		}
		else {
			System.out.println("The store is full");
		}
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < qtyInStore; i++) {
			if (itemsInStore[i] == dvd) continue;
			
			for (int j = i; j < qtyInStore - 1; j++) itemsInStore[j] = itemsInStore[j+1];
			itemsInStore[qtyInStore-1] = null;
			qtyInStore--;
			System.out.println("The DVD has been removed from the store");
			
			return;
		}
		
		System.out.println("The DVD was not found");
	}
	*/
}
