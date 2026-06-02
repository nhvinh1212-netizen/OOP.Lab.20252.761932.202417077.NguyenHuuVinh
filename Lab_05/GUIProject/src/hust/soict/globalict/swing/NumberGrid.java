package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // Mảng chứa 10 nút từ 0 đến 9
    private JButton btnDelete, btnReset;            // Nút DEL và nút C
    private JTextField tfDisplay;                   // Màn hình hiển thị số

    public NumberGrid() {
        // 1. Khởi tạo ô hiển thị và đặt cấu hình chữ chạy từ phải sang trái (giống máy tính bỏ túi)
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setEditable(false); // Không cho người dùng gõ từ bàn phím cơ vào

        // 2. Tạo một JPanel chứa các nút bấm với lưới 4 hàng, 3 cột
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons); // Gọi hàm phụ trách tạo và nhét nút vào panel

        // 3. Lấy phân vùng chứa của JFrame và thiết lập BorderLayout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // 4. Sắp xếp vị trí các thành phần lớn lên JFrame
        cp.add(tfDisplay, BorderLayout.NORTH);       // Thanh hiển thị ở trên cùng
        cp.add(panelButtons, BorderLayout.CENTER);   // Cụm nút bấm ở giữa chiếm trọn diện tích

        // 5. Cấu hình cơ bản cho cửa sổ ứng dụng
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(250, 250); // Có thể tăng lên 250x250 để giao diện nhìn thoáng và đẹp hơn
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
    void addButtons(JPanel panelButtons) {
        // Khởi tạo một Listener dùng chung cho tất cả các nút
        ButtonListener btnListener = new ButtonListener();

        // Tạo và add các nút từ 1 đến 9 bằng vòng lặp
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener); // Đăng ký sự kiện
        }

        // Tạo và add nút DEL (Xóa 1 ký tự cuối)
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Tạo và add nút số 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Tạo và add nút C (Clear - Xóa hết sạch)
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }
 // Lớp nội bộ lắng nghe và xử lý sự kiện bấm nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy nhãn văn bản của nút vừa bấm (Ví dụ: "1", "5", "DEL", "C")
            String button = e.getActionCommand();

            // Trường hợp 1: Nếu người dùng bấm các nút số từ '0' đến '9'
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            } 
            // Trường hợp 2: Nếu người dùng bấm nút xóa một ký tự "DEL"
            else if (button.equals("DEL")) {
                String currentText = tfDisplay.getText();
                // Chỉ xóa khi màn hình đang có chữ/số
                if (currentText != null && currentText.length() > 0) {
                    // Cắt chuỗi từ ký tự đầu tiên (0) đến sát ký tự cuối cùng (length - 1)
                    String newText = currentText.substring(0, currentText.length() - 1);
                    tfDisplay.setText(newText);
                }
            } 
            // Trường hợp 3: Nếu người dùng bấm nút xóa sạch "C"
            else if (button.equals("C")) {
                tfDisplay.setText(""); // Đặt lại màn hình hiển thị thành rỗng
            }
        }
    }
} // Dấu đóng của lớp NumberGrid
