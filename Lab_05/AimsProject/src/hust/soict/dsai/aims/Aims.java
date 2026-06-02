package hust.soict.dsai.aims;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {

    public static void main(String[] args) {

        // DVD lỗi
        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        1,
                        "Invalid DVD",
                        "Action",
                        20.5f,
                        "Director A",
                        0
                );

        try {

            dvd.play();

        } catch (PlayerException e) {

            // getMessage()

            System.err.println(
                    e.getMessage()
            );

            // toString()

            System.err.println(
                    e.toString()
            );

            // stack trace

            e.printStackTrace();
        }
    }
}