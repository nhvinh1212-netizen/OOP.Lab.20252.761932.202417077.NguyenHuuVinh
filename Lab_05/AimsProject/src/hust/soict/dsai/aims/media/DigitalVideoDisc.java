package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    
    // XÓA BỎ thuộc tính director và length ở đây vì Disc đã có

    public DigitalVideoDisc (int id, String title, String category, float cost, String director, int length) {
        // Hãy chú ý thứ tự tham số truyền vào super() phải khớp với lớp Disc của bạn
        super(id, title, category, cost, director, length);
    }
    
    // Sửa lại các hàm lấy dữ liệu từ lớp cha Disc bằng cách gọi hàm getter của cha
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
    
    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }
    
    @Override
    public void play() throws PlayerException {

        if (this.getLength() <= 0) {

            throw new PlayerException(
                    "ERROR: DVD length is non-positive!"
            );
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}