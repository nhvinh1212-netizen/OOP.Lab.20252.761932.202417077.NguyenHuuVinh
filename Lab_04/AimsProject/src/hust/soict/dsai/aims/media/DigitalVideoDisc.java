package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director	;
	private int length;
	
	public DigitalVideoDisc (int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost, director, length);
		
	}
	
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	@Override
	public String toString() {
		return "DVD -  " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + " + " + ": " + getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		return getTitle().toLowerCase().contains(title.toLowerCase());
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}

}
