package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	//private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	//private int qtyOrdered = 0;
	private ObservableList<Media> itemsOrdered = 
	        FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
	
	public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST); 
        System.out.println("Giỏ hàng đã được sắp xếp theo thứ tự Tiêu đề (rồi đến Giá).");
    }

    // Phương thức sắp xếp danh sách giỏ hàng theo Giá -> Tiêu đề
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE); 
        System.out.println("Giỏ hàng đã được sắp xếp theo thứ tự Giá giảm dần (rồi đến Tiêu đề).");
    }
	
	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			System.out.println("Sản phẩm '" + media.getTitle() + "' đã có sẵn trong giỏ hàng!");
		}
		else {
			itemsOrdered.add(media);
			System.out.println("Đã thêm thành công sản phẩm '" + media.getTitle() + "' vào giỏ hàng.");
		}
	}
	
	public void removeMedia(Media media) {
        // Kiểm tra xem sản phẩm có tồn tại để xóa không
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa sản phẩm '" + media.getTitle() + "' khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm '" + media.getTitle() + "' trong giỏ hàng để xóa.");
        }
    }
	
	// Phương thức tính tổng giá tiền các sản phẩm trong giỏ hàng
    public float totalCost() {
        float total = 0.0f;
        
        // Duyệt qua từng đối tượng Media có trong danh sách itemsOrdered
        for (Media media : itemsOrdered) {
            total += media.getCost(); // Tính đa hình: lấy đúng giá của từng đối tượng cụ thể (Book/CD/DVD)
        }
        
        return total;
    }
	
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else System.out.println("The cart is almost full");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc Disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = Disc;
				qtyOrdered++;
				System.out.println("The disc has been added");
			}
			else {
	            System.out.println("The cart is almost full");
	            break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else System.out.println("The cart is almost full");
		
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else System.out.println("The cart is almost full");
	}

	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i] == disc) {
	            for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }
	            itemsOrdered[qtyOrdered - 1] = null;
	            qtyOrdered--;
	            System.out.println("The disc has been removed");
	            return;
	        }
	    }
	    System.out.println("The disc was not found");
	}
	
	public float totalCost() {
	    float total = 0;
	    for (int i = 0; i < qtyOrdered; i++) {
	        total += itemsOrdered[i].getCost();
	    }
	    return total;
	}
	
	public void printCart() {
	    System.out.println("***********************CART***********************");
	    System.out.println("Ordered Items:");

	    for (int i = 0; i < qtyOrdered; i++) {
	        System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
	    }

	    System.out.println("Total cost: " + totalCost());
	    System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
	    boolean found = false;

	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].getId() == id) {
	            System.out.println("Found: " + itemsOrdered[i]);
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No matching DVD found.");
	    }
	}
	
	public void searchByTitle(String title) {
	    boolean found = false;

	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].isMatch(title)) {
	            System.out.println("Found: " + itemsOrdered[i]);
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No matching DVD found.");
	    }
	}
	*/
}	
