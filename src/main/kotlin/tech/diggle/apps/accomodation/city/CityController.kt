package tech.diggle.apps.accomodation.city

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("city")
class CityController {
    @GetMapping("movies")
    fun getMovies(model: Model): String {
        model.addAttribute("title", "Movies")
        return "city/movies"
    }

    @GetMapping("recreation")
    fun getRecreation(model: Model): String {
        model.addAttribute("title", "Recreation")
        return "city/recreation"
    }

    @GetMapping("travel")
    fun getTravel(model: Model): String {
        model.addAttribute("title", "Travel")
        return "city/travel"
    }
}