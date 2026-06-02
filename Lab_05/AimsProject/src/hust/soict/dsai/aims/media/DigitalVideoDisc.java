package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc
        extends Media
        implements Playable {

    private String director;
    private int length;

    public DigitalVideoDisc(
            int id,
            String title,
            String category,
            float cost,
            String director,
            int length
    ) {

        super(id, title, category, cost);

        this.director = director;
        this.length = length;
    }

    public int getLength() {

        return length;
    }

    @Override
    public void play() throws PlayerException {

        if (this.getLength() <= 0) {

            throw new PlayerException(
                    "ERROR: DVD length is non-positive!"
            );
        }

        System.out.println("Playing DVD: "
                + this.getTitle());

        System.out.println("DVD length: "
                + this.getLength());
    }
}