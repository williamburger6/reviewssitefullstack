package will.wecancodeit.reviewssitefullstack.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import will.wecancodeit.reviewssitefullstack.Models.Movie;
import will.wecancodeit.reviewssitefullstack.Repositories.MovieRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class MovieController {

    @Resource
    private MovieRepository movieRepo;

    @RequestMapping("/movies")
    public String displayMovies(Model model){
        model.addAttribute("movies", movieRepo.findAll());
        return "moviesView";
    }

    @RequestMapping("/movies/{id}")
    public String displaySingleBook(@PathVariable long id, Model model){
        Optional<Movie> retrievedMovie = movieRepo.findById(id);
        Movie foundMovie = retrievedMovie.get();
        model.addAttribute("movie",foundMovie);
        return "movieView";
    }
}