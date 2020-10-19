package will.wecancodeit.reviewssitefullstack.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    String title;
    private String review;
    @ManyToOne
    private Genre genre;
    @ManyToMany
    private Collection<Rating> ratings;

    public Long getId() {
        return id;
    }

    public Movie(){

    }

    public Movie(String title, String review, Genre genre, Rating...ratings) {
        this.title=title;
        this.review=review;
        this.genre=genre;
        this.ratings=new ArrayList<>(Arrays.asList(ratings));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

public String getTitle() {
        return title;
    }

    public String getReview (){
        return review;
    }

    public Genre getGenre (){
        return genre;
    }


}
