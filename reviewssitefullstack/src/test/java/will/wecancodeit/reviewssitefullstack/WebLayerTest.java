package will.wecancodeit.reviewssitefullstack;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import will.wecancodeit.reviewssitefullstack.Models.Genre;
import will.wecancodeit.reviewssitefullstack.Models.Movie;
import will.wecancodeit.reviewssitefullstack.Models.Rating;
import will.wecancodeit.reviewssitefullstack.Repositories.GenreRepository;
import will.wecancodeit.reviewssitefullstack.Repositories.MovieRepository;
import will.wecancodeit.reviewssitefullstack.Repositories.RatingRepository;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private GenreRepository genreRepo;

    @MockBean
    private MovieRepository movieRepo;

    @MockBean
    private RatingRepository ratingRepo;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void genresShouldBeOkAndReturnGenresViewWithGenresModelAttribute() throws Exception{
        mockMvc.perform(get("/genres"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("genresView"))
                .andExpect(model().attributeExists("genres"));
    }

    @Test
    public void moviesShouldBeOkAndReturnMoviesViewWithMoviesModelAttribute() throws Exception{
        mockMvc.perform(get("/movies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("moviesView"))
                .andExpect(model().attributeExists("movies"));
    }

    @Test
    public void ratingsShouldBeOkAndReturnRatingsViewWithRatingsModelAttribute() throws Exception{
        mockMvc.perform(get("/ratings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("ratingsView"))
                .andExpect(model().attributeExists("ratings"));
    }

    @Test
    public void shouldBeOkForASingleGenreEndpointWithGenresViewAndGenresModelAttribute() throws Exception{
        Genre testGenre = new Genre("Horror");
        when(genreRepo.findGenreByCategory("Horror")).thenReturn(testGenre);
        mockMvc.perform(get("/genres/Horror"))
                .andExpect(status().isOk())
                .andExpect(view().name("genreView"))
                .andExpect(model().attributeExists("genre"));
    }

    @Test
    public void shouldBeOkForASingleMovieEndpointWithMoviesViewAndMoviesModelAttribute() throws Exception{
        Genre testGenre = new Genre("Horror");
        Rating testRating = new Rating("Good");
        Movie testMovie = new Movie("Title","Description",testGenre,testRating);
        when(movieRepo.findById(1L)).thenReturn(java.util.Optional.of(testMovie));
        mockMvc.perform(get("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("movieView"))
                .andExpect(model().attributeExists("movie"));
    }

}
