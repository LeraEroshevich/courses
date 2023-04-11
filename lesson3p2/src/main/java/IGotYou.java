public class IGotYou extends Music implements MusicWithClip, MusicWithoutClip {

    public IGotYou(Genre genre, String author, int releaseYear) {
        super(genre, author, releaseYear);
    }

    @Override
    public void playMusicWithClip() {
        System.out.println("Playing I Got You music with clip");
    }

    @Override
    public void playMusicWithoutClip() {
        System.out.println("Playing I Got You music without clip");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing I Got You music");
    }
}
