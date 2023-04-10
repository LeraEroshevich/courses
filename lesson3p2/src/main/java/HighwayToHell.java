public class HighwayToHell extends Music implements MusicWithClip {

    public HighwayToHell(Genre genre, String author, int releaseYear) {
        super(genre, author, releaseYear);
    }

    @Override
    public void playMusicWithClip() {
        System.out.println("Playing Highway To Hell music with clip");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing Highway To Hell music");
    }
}