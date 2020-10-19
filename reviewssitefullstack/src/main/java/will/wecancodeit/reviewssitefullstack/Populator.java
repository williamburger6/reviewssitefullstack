package will.wecancodeit.reviewssitefullstack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import will.wecancodeit.reviewssitefullstack.Models.Genre;
import will.wecancodeit.reviewssitefullstack.Models.Movie;
import will.wecancodeit.reviewssitefullstack.Models.Rating;
import will.wecancodeit.reviewssitefullstack.Repositories.GenreRepository;
import will.wecancodeit.reviewssitefullstack.Repositories.MovieRepository;
import will.wecancodeit.reviewssitefullstack.Repositories.RatingRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {
    @Resource
    private GenreRepository genreRepo;
    @Resource
    private RatingRepository ratingRepo;
    @Resource
    private MovieRepository movieRepo;

    @Override
    public void run(String... args) throws Exception {

        Genre horror = new Genre("Horror");
        genreRepo.save(horror);
        Genre comedy = new Genre("Comedy");
        genreRepo.save(comedy);
        Genre children = new Genre("Children");
        genreRepo.save(children);

        Rating good = new Rating("Good");
        Rating average = new Rating("Average");
        Rating bad = new Rating("Bad");
        Rating wouldRecommend = new Rating("Would Recommend");
        Rating wouldNotRecommend = new Rating("Would Not Recommend");
        ratingRepo.save(good);
        ratingRepo.save(average);
        ratingRepo.save(bad);
        ratingRepo.save(wouldRecommend);
        ratingRepo.save(wouldNotRecommend);

        Movie bambi = new Movie("Bambi","Great Children's Movie",children,good,wouldRecommend);
        Movie comedyMovie = new Movie("Comedy Movie","Not very funny for a funny movie",comedy,bad,wouldNotRecommend);
        Movie scaryMovie = new Movie("Scary Movie","Average horror film",horror,average);
        movieRepo.save(bambi);
        movieRepo.save(comedyMovie);
        movieRepo.save(scaryMovie);
    }
}
