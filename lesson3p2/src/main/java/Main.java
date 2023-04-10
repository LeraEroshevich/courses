public class Main {
    public static void main(String[] args) {
        Apologize apologize = new Apologize(Genre.ROCK,"OneRepublic", 2007);
        IGotYou iGotYou = new IGotYou(Genre.CLASSIC,"Michael Bublé", 2011);
        HighwayToHell highwayToHell = new HighwayToHell(Genre.JAZZ, "AC/DC", 1979);
        Anberlin anberlin = new Anberlin(Genre.METAL, "Test", 2002);
        Music[] songs = new Music[]{apologize, iGotYou, highwayToHell, anberlin};
        Radio radio = new Radio();
        System.out.println("Songs without Clips");
        radio.playMusicWithoutVideo(songs);
        System.out.println("Songs with Clips");
        radio.playMusicWithVideo(songs);
    }
}
