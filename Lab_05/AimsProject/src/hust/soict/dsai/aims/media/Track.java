package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra nếu so sánh với chính nó trong bộ nhớ
        if (this == obj) {
            return true;
        }
        
        // 2. Kiểm tra null và kiểm tra xem obj có phải là một Track không
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }
        
        // 3. Ép kiểu từ Object sang Track
        Track other = (Track) obj;
        
        // 4. Kiểm tra điều kiện 1: Thời lượng (length) phải bằng nhau
        if (this.length != other.length) {
            return false;
        }
        
        // 5. Kiểm tra điều kiện 2: Tiêu đề (title) phải bằng nhau
        if (this.title == null) {
            return other.title == null;
        }
        
        return this.title.equalsIgnoreCase(other.title);
    }

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public void play() throws PlayerException {

	    if (this.getLength() <= 0) {

	        throw new PlayerException(
	                "ERROR: Track length is non-positive!"
	        );
	    }

	    System.out.println("Playing track: " + this.getTitle());
	    System.out.println("Track length: " + this.getLength());
	}
}
