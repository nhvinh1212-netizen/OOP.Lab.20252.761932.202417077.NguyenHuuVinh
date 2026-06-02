package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // 1. So sánh giá giảm dần (giá cao hơn đứng trước)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        
        // Nếu giá khác nhau thì trả về kết quả luôn
        if (costCompare != 0) {
            return costCompare;
        }
        
        // 2. Nếu bằng giá nhau, so sánh tiêu đề theo bảng chữ cái (A-Z)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}