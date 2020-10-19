package will.wecancodeit.reviewssitefullstack.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    @ManyToMany(mappedBy = "ratings")
    private Collection<Movie> movies;

    public Collection<Movie> getMovies(){
        return movies;
    }

    public Rating(){

    }

    public Rating(String rating){
        this.rating=rating;

    }

    public Long getId() {
        return id;
    }

    public String getRating(){
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(id, rating.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
