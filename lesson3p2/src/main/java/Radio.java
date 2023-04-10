class Radio {
    public void playMusicWithVideo(Music[] music) {
        for (Music m : music) {
            if (m instanceof MusicWithClip) {
                System.out.println(m.toString() + "\n" +  m.getGenre() + "\n" + m.getAuthor() + "\n" + m.getReleaseYear() + "\n");

            }
        }
    }

    public void playMusicWithoutVideo(Music[] music) {
        for (Music m : music) {
            if (m instanceof MusicWithoutClip) {
                System.out.println (m.toString() + "\n" +  m.getGenre() + "\n" + m.getAuthor() + "\n" + m.getReleaseYear() + "\n");

            }
        }
    }
}
