package will.wecancodeit.reviewssitefullstack.Repositories;

import org.springframework.data.repository.CrudRepository;
import will.wecancodeit.reviewssitefullstack.Models.Rating;

public interface RatingRepository extends CrudRepository <Rating, Long> {
}
