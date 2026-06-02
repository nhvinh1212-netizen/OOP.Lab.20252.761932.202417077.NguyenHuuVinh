package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(
	        int id,
	        String title,
	        String category,
	        float cost
	) {

	    if (cost < 0) {

	        throw new IllegalArgumentException(
	                "Cost cannot be negative!"
	        );
	    }

	    this.id = id;
	    this.title = title;
	    this.category = category;
	    this.cost = cost;
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost(); 
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle(); 
	
	@Override
	public boolean equals(Object obj) {

	    if (this == obj) {
	        return true;
	    }

	    if (obj == null) {
	        return false;
	    }

	    if (!(obj instanceof Media)) {
	        return false;
	    }

	    Media other = (Media) obj;

	    return this.title.equals(other.title);
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	
	@Override
    public String toString() {
        return title + " - " + category + " - " + cost + " $";
    }
	
}	
