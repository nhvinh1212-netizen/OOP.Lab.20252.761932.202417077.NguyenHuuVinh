package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.*;

// 1. Lớp ứng dụng kế thừa trực tiếp từ Frame (AWT)
public class AWTAccumulator extends Frame { 
    private TextField tfInput;   // Ô nhập dữ liệu
    private TextField tfOutput;  // Ô hiển thị tổng tích lũy
    private int sum = 0;         // Biến lưu tổng tích lũy, khởi tạo bằng 0

    // Constructor thiết lập giao diện và trình xử lý sự kiện
    public AWTAccumulator() {
        // Cài đặt bố cục dạng lưới 2 hàng, 2 cột
        setLayout(new GridLayout(2, 2)); 

        // Hàng 1: Label gợi ý và Ô nhập dữ liệu
        add(new Label("Enter an Integer: ")); 
        tfInput = new TextField(10); 
        add(tfInput);
        
        // Đăng ký bộ lắng nghe sự kiện khi người dùng nhấn "Enter" ở ô nhập
        tfInput.addActionListener(new TFInputListener()); 

        // Hàng 2: Label hiển thị và Ô kết quả
        add(new Label("The Accumulated Sum is: ")); 
        tfOutput = new TextField(10); 
        tfOutput.setEditable(false); // Đặt thuộc tính chỉ đọc (Read-only)
        add(tfOutput); 

        // Thiết lập các thuộc tính của cửa sổ Frame
        setTitle("AWT Accumulator"); 
        setSize(350, 120); 
        setVisible(true); // Hiển thị cửa sổ lên màn hình
    }

    public static void main(String[] args) {
        // Khởi chạy ứng dụng
        new AWTAccumulator(); 
    }

    // 2. Lớp nội bộ (Inner Class) xử lý sự kiện khi gõ Enter
    private class TFInputListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent evt) { 
            // Lấy chuỗi từ ô nhập và ép kiểu sang số nguyên
            int numberIn = Integer.parseInt(tfInput.getText()); 
            sum += numberIn;      // Cộng dồn vào biến sum
            tfInput.setText("");  // Xóa trống ô nhập để người dùng nhập số tiếp theo
            tfOutput.setText(sum + ""); // Hiển thị tổng mới lên ô kết quả
        } 
    } 
}
