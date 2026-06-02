package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

    private String artist;

    private ArrayList<Track> tracks =
            new ArrayList<>();

    // ==========================
    // CONSTRUCTOR
    // ==========================

    public CompactDisc(
            int id,
            String title,
            String category,
            float cost,
            String director,
            int length,
            String artist,
            ArrayList<Track> tracks
    ) {

        super(
                id,
                title,
                category,
                cost,
                director,
                length
        );

        this.artist = artist;

        this.tracks = tracks;
    }

    // ==========================
    // GETTER
    // ==========================

    public String getArtist() {

        return artist;
    }

    // ==========================
    // ADD TRACK
    // ==========================

    public void addTrack(Track track) {

        if (tracks.contains(track)) {

            System.out.println(
                    "Track already exists."
            );

        } else {

            tracks.add(track);

            System.out.println(
                    "Track added."
            );
        }
    }

    // ==========================
    // REMOVE TRACK
    // ==========================

    public void removeTrack(Track track) {

        if (tracks.contains(track)) {

            tracks.remove(track);

            System.out.println(
                    "Track removed."
            );

        } else {

            System.out.println(
                    "Track not found."
            );
        }
    }

    // ==========================
    // GET LENGTH
    // ==========================

    @Override
    public int getLength() {

        int total = 0;

        for (Track track : tracks) {

            total += track.getLength();
        }

        return total;
    }

    // ==========================
    // PLAY
    // ==========================

    @Override
    public void play()
            throws PlayerException {

        if (getLength() <= 0) {

            throw new PlayerException(
                    "ERROR: CD length is non-positive!"
            );
        }

        System.out.println(
                "Playing CD: " + getTitle()
        );

        for (Track track : tracks) {

            try {

                track.play();

            } catch (PlayerException e) {

                throw e;
            }
        }
    }
}