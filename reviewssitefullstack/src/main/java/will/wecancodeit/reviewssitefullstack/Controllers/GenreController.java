package will.wecancodeit.reviewssitefullstack.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import will.wecancodeit.reviewssitefullstack.Models.Genre;
import will.wecancodeit.reviewssitefullstack.Repositories.GenreRepository;

import javax.annotation.Resource;

@Controller
public class GenreController {

    @Resource
    private GenreRepository genreRepo;

    @RequestMapping({"/genres", "/",""})
    public String displayGenres(Model model){
        model.addAttribute("genres", genreRepo.findAll());
        return "genresView";
    }

    @GetMapping("/genres/{category}")
    public String displaySingleGenre(@PathVariable String category, Model model){
        Genre retrievedGenre = genreRepo.findGenreByCategory(category);
        model.addAttribute("genre", retrievedGenre);
        return "genreView";
    }
}
