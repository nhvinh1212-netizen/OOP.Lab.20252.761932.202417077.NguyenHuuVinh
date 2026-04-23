package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
	
	private int qtyInStore = 0;
	
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
}
