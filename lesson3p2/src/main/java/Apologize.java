public class Apologize extends Music implements MusicWithClip, MusicWithoutClip {

    public Apologize(Genre genre, String author, int releaseYear) {
        super(genre, author, releaseYear);
    }

    @Override
    public void playMusicWithClip() {
        System.out.println("Playing Apologize music with clip");
    }

    @Override
    public void playMusicWithoutClip() {
        System.out.println("Playing Apologize music without clip");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing Apologize music");
    }
}