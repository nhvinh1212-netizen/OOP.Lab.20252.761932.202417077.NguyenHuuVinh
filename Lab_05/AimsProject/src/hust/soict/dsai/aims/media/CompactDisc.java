package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	

	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist,
			ArrayList<Track> tracks) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
            System.out.println("Thông báo: Bài hát '" + track.getTitle() + "' đã tồn tại trong danh sách của CD.");
        } else {
            tracks.add(track);
            System.out.println("Thành công: Đã thêm bài hát '" + track.getTitle() + "' vào CD.");
        }
    }
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);System.out.println("Thành công: Đã xóa bài hát '" + track.getTitle() + "' khỏi CD.");
        } else {
            System.out.println("Thông báo: Bài hát '" + track.getTitle() + "' không tồn tại trong CD này.");
        }
	}
	
	@Override 
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength() + " min: " + getCost() + " $";
    }
	
    @Override
    public void play() throws PlayerException {

        if (this.getLength() <= 0) {

            throw new PlayerException(
                    "ERROR: CD length is non-positive!"
            );
        }

        System.out.println("Playing CD: " + this.getTitle());

        for (Track track : tracks) {

            try {

                track.play();

            } catch (PlayerException e) {

                throw e;
            }
        }
    }
	
}
