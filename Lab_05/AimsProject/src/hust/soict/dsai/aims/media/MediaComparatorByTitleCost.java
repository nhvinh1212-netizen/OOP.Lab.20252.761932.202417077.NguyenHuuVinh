package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. So sánh tiêu đề theo bảng chữ cái (A-Z)
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        
        // Nếu tiêu đề khác nhau thì trả về kết quả luôn
        if (titleCompare != 0) {
            return titleCompare;
        }
        
        // 2. Nếu trùng tiêu đề, so sánh giá giảm dần (giá cao hơn đứng trước)
        // m2.getCost() so với m1.getCost() tạo ra thứ tự giảm dần
        return Float.compare(m2.getCost(), m1.getCost());
    }
}