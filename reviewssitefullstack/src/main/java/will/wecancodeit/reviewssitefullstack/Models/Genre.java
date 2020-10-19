package will.wecancodeit.reviewssitefullstack.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Long id;
    private String category;
    @OneToMany(mappedBy = "genre")
    private Collection<Movie> movies;

    public Genre(){

    }

    public String getCategory() {
        return category;
    }

    public Genre(String category){
        this.category=category;

    }

    public Long getId() {
        return id;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
