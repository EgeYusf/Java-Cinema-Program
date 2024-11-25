// Movie Sınıfı
class Movie {
    private String movieName;
    private int movieDuration;
    private String movieGenre;

    public Movie(String movieName, int movieDuration, String movieGenre) {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.movieGenre = movieGenre;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void BilgiGoster() { // Polymorphism kullanıldı.
        System.out.println("Movie Name: " + movieName + ", Duration: " + movieDuration + " mins, Genre: " + movieGenre);
    }
}











