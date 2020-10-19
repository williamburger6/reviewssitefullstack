package will.wecancodeit.reviewssitefullstack.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import will.wecancodeit.reviewssitefullstack.Repositories.RatingRepository;

import javax.annotation.Resource;

@Controller
public class RatingController {

    @Resource
    private RatingRepository ratingRepo;

    @RequestMapping("/ratings")
    public String displayRatings(Model model){
        model.addAttribute("ratings", ratingRepo.findAll());
        return "ratingsView";
    }
}