package will.wecancodeit.reviewssitefullstack;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import will.wecancodeit.reviewssitefullstack.Models.Genre;
import will.wecancodeit.reviewssitefullstack.Models.Movie;
import will.wecancodeit.reviewssitefullstack.Models.Rating;
import will.wecancodeit.reviewssitefullstack.Repositories.GenreRepository;
import will.wecancodeit.reviewssitefullstack.Repositories.MovieRepository;
import will.wecancodeit.reviewssitefullstack.Repositories.RatingRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenreRepository genreRepo;

    @Autowired
    private RatingRepository ratingRepo;

    @Autowired
    private MovieRepository movieRepo;

    @Test
    public void categoriesShouldHaveAListOfMovies(){
        Genre testGenre = new Genre("Test Category");
        Genre testGenre2 = new Genre("Test Category2");
        Rating testRating1 = new Rating("Test Rating");
        Movie testMovie = new Movie("Title","Review", testGenre,testRating1);
        Movie testMovie2 = new Movie("Title","Review", testGenre,testRating1);

        genreRepo.save(testGenre);
        genreRepo.save(testGenre2);
        ratingRepo.save(testRating1);
        movieRepo.save(testMovie);
        movieRepo.save(testMovie2);

        entityManager.flush();
        entityManager.clear();

        Optional<Genre> retrievedGenreOpt = genreRepo.findById(testGenre.getId());
        Genre retrievedGenre = retrievedGenreOpt.get();
        Movie retrievedMovie = movieRepo.findById(testMovie.getId()).get();
        assertThat(retrievedGenre.getMovies()).contains(testMovie, testMovie2);
    }

    @Test
    public void moviesShouldHaveMultipleRatings(){
        Genre testGenre = new Genre("Test Category");
        Rating testRating1 = new Rating("Test Rating");
        Rating testRating2 = new Rating("Test Rating2");
        Movie testMovie1 = new Movie("Title","Review", testGenre,testRating1, testRating2);
        Movie testMovie2 = new Movie("Title","Review", testGenre,testRating1);
        Movie testMovie3 = new Movie("Title","Review", testGenre,testRating2);
        genreRepo.save(testGenre);
        ratingRepo.save(testRating1);
        ratingRepo.save(testRating2);
        movieRepo.save(testMovie1);
        movieRepo.save(testMovie2);
        movieRepo.save(testMovie3);

        entityManager.flush();
        entityManager.clear();

        Movie retrievedMovie1 = movieRepo.findById(testMovie1.getId()).get();
        Rating retrievedRating1 = ratingRepo.findById(testRating1.getId()).get();
        Rating retrievedRating2 = ratingRepo.findById(testRating2.getId()).get();
        assertThat(retrievedMovie1.getRatings()).contains(testRating1,testRating2);
    }
}
