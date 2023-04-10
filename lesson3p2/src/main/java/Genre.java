public enum Genre {
    POP(909),
    JAZZ(1273),
    METAL(1580),
    ROCK(998),
    CLASSIC(1540) {
        @Override
        public String getDescription() {
            return "Музыка 1960";
        }
    };

    private int musicRecords;

    Genre(int musicRecords) {
        this.musicRecords = musicRecords;
    }

    public int getMusicRecords() {
        return musicRecords;
    }

    public String getDescription() {
        return "Музыка 2000";
    }
}



