package Lab__01;

import javax.swing.JOptionPane;

public class Bai_2_2_6 {
	public static void main(String[] args) {
        String[] options = {"Bậc 1 (1 ẩn)", "Hệ bậc 1 (2 ẩn)", "Bậc 2 (1 ẩn)"};
        int choice = JOptionPane.showOptionDialog(null, "Chọn loại phương trình cần giải:", 
                "Giải phương trình - Nguyễn Hữu Vinh", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) solveFirstDegree();
        else if (choice == 1) solveSystemFirstDegree();
        else if (choice == 2) solveSecondDegree();
        
        System.exit(0);
    }

    // 1. Phương trình bậc nhất: ax + b = 0
    private static void solveFirstDegree() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a (ax + b = 0):"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b (ax + b = 0):"));
        if (a == 0) {
            JOptionPane.showMessageDialog(null, b == 0 ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm");
        } else {
            JOptionPane.showMessageDialog(null, "Nghiệm x = " + (-b / a));
        }
    }

    // 2. Hệ phương trình bậc nhất 2 ẩn
    private static void solveSystemFirstDegree() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "Hệ có nghiệm duy nhất: x1 = " + (D1/D) + ", x2 = " + (D2/D));
        } else {
            JOptionPane.showMessageDialog(null, (D1 == 0 && D2 == 0) ? "Hệ vô số nghiệm" : "Hệ vô nghiệm");
        }
    }

    // 3. Phương trình bậc hai: ax^2 + bx + c = 0
    private static void solveSecondDegree() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Đây là PT bậc nhất. Nghiệm x = " + (-c/b));
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "PT có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "PT có nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực.");
            }
        }
    }
}
