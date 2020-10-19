package will.wecancodeit.reviewssitefullstack.Repositories;

import org.springframework.data.repository.CrudRepository;
import will.wecancodeit.reviewssitefullstack.Models.Movie;

public interface MovieRepository extends CrudRepository <Movie, Long> {
}
