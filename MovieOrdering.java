public class MovieOrdering {
//    Movie[] movies;
//    static final int SIZE = 9;
    public Movie head, tail;
    public int length;

    public MovieOrdering() {
        this.length = 0;
    }
    public void addMovie(Movie prevMovie, Movie currentMovie) {
        if (prevMovie != null) {
            if (prevMovie.next != null) {
                currentMovie.next = prevMovie.next;
                prevMovie.next = currentMovie;
            } else {
                prevMovie.next = currentMovie;
                tail = currentMovie;
            }
        } else if (prevMovie == null) {
            head = currentMovie;
            tail = head;
        }
        length += 1;
    }
    
    public int currentJoyfulness() {
        Movie p = head;
        int joyfulness = p.duration;

        for (int i=0; i < this.length; i++) {
            if (p != null && p.next != null) {
                if ((p.genre != p.next.genre) && (p.rating < p.next.rating)) {
                    joyfulness += p.next.duration;
                    p = p.next;
                } else {
                    p = p.next;
                }
            }
        }
        return joyfulness;
    }

//    public int maxJoyfulness() {
//
//    }

    public static void main(String[] args) {
        Movie a = new Movie("Squid Game", "Thriller", 8.6, 120);
        Movie b = new Movie("Spider-Man", "Action", 8.5, 110);
        Movie c = new Movie("The Matrix Resurrections", "Action", 8.7, 140);
        Movie d = new Movie("Annabelle", "Horror", 9.2, 100);
        MovieOrdering mo = new MovieOrdering();

        mo.addMovie(null, a);
        mo.addMovie(a, b);
        mo.addMovie(b, c);
        mo.addMovie(c, d);

        System.out.println("Number of movies: " + mo.length);
        System.out.println("Current joyfulness: " + mo.currentJoyfulness());
    }
}

class Movie {
    // Attributes
    public String title;
    public String genre;
    public double rating;
    public int duration;
    Movie prev, next;

    // Constructor
    public Movie(String title, String genre, double rating, int duration) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.prev = null;
        this.next = null;
    }
}
