package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Nếu chọn Eraser → dùng màu trắng (màu nền canvas)
        // Nếu chọn Pen    → dùng màu đen
        Color color = radioEraser.isSelected() ? Color.WHITE : Color.BLACK;

        // Eraser thì circle to hơn để xóa dễ hơn
        double radius = radioEraser.isSelected() ? 10 : 4;

        Circle newCircle = new Circle(
            event.getX(),
            event.getY(),
            radius,
            color
        );

        drawingAreaPane.getChildren().add(newCircle);
    }
}