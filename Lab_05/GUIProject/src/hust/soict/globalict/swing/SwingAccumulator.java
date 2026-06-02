package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Import thêm thư viện Swing

// 1. Lớp ứng dụng kế thừa từ JFrame (Swing)
public class SwingAccumulator extends JFrame { 
    private JTextField tfInput;   // Sử dụng JTextField của Swing
    private JTextField tfOutput;  // Sử dụng JTextField của Swing
    private int sum = 0;          // Tổng tích lũy ban đầu bằng 0

    // Constructor thiết lập giao diện Swing
    public SwingAccumulator() {
        // LƯU Ý: Lấy phân vùng chứa (Content Pane) của JFrame để quản lý thành phần
        Container cp = getContentPane(); 
        cp.setLayout(new GridLayout(2, 2)); 

        // Thêm các JComponent vào Content Pane thay vì add trực tiếp vào JFrame
        cp.add(new JLabel("Enter an Integer: ")); 
        tfInput = new JTextField(10); 
        cp.add(tfInput);
        
        // Đăng ký bộ lắng nghe sự kiện hành động
        tfInput.addActionListener(new TFInputListener()); 

        cp.add(new JLabel("The Accumulated Sum is: ")); 
        tfOutput = new JTextField(10); 
        tfOutput.setEditable(false); 
        cp.add(tfOutput); 

        // Thiết lập thuộc tính cho cửa sổ JFrame
        setTitle("Swing Accumulator"); 
        setSize(350, 120); 
        
        // Thêm dòng này để chương trình thực sự tắt hẳn khi bạn bấm nút [X] cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        setVisible(true); 
    }

    public static void main(String[] args) {
        new SwingAccumulator(); 
    }

    // 2. Bộ lắng nghe sự kiện (Tương tự như bên AWT)
    private class TFInputListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent evt) { 
            int numberIn = Integer.parseInt(tfInput.getText()); 
            sum += numberIn; 
            tfInput.setText(""); 
            tfOutput.setText(sum + ""); 
        } 
    } 
}
