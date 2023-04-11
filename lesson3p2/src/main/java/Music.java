public abstract class Music {
    private Genre genre;
    private String author;
    private int releaseYear;

    public Music(Genre genre, String author, int releaseYear) {
        this.genre = genre;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public abstract void playMusic();
}