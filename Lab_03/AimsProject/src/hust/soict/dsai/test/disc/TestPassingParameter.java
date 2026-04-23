package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    // Hàm thử swap (KHÔNG hoạt động)
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        System.out.println("Inside swap method:");

        DigitalVideoDisc temp = dvd1;
        dvd1 = dvd2;
        dvd2 = temp;

        System.out.println("dvd1 title: " + dvd1.getTitle());
        System.out.println("dvd2 title: " + dvd2.getTitle());
    }

    // Hàm đổi dữ liệu bên trong object
    public static void changeTitle(DigitalVideoDisc dvd) {
        System.out.println("Before change: " + dvd.getTitle());

        // Không có setter nên tạo object mới (chỉ đổi local)
        dvd = new DigitalVideoDisc(
                "New Title",
                dvd.getCategory(),
                dvd.getDirector(),
                dvd.getLength(),
                dvd.getCost()
        );

        System.out.println("After change inside method: " + dvd.getTitle());
    }

    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "DVD One",
                "Category 1",
                "Director 1",
                100,
                10.0f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "DVD Two",
                "Category 2",
                "Director 2",
                120,
                12.0f
        );

        // Test swap
        System.out.println("Before swap:");
        System.out.println("dvd1: " + dvd1.getTitle());
        System.out.println("dvd2: " + dvd2.getTitle());

        swap(dvd1, dvd2);

        System.out.println("After swap:");
        System.out.println("dvd1: " + dvd1.getTitle());
        System.out.println("dvd2: " + dvd2.getTitle());

        // Test changeTitle
        changeTitle(dvd1);

        System.out.println("After changeTitle:");
        System.out.println("dvd1: " + dvd1.getTitle());
    }
}