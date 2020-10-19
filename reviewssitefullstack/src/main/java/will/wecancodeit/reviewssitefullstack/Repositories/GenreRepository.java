package will.wecancodeit.reviewssitefullstack.Repositories;

import org.springframework.data.repository.CrudRepository;
import will.wecancodeit.reviewssitefullstack.Models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findGenreByCategory(String category);
}
