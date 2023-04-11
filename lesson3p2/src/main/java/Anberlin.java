public class Anberlin extends Music implements MusicWithoutClip {

    public Anberlin(Genre genre, String author, int releaseYear) {
        super(genre, author, releaseYear);
    }

    @Override
    public void playMusicWithoutClip() {
        System.out.println("Playing Anberlin music without clip");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing Anberlin music");
    }
}