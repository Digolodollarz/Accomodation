package tech.diggle.apps.accomodation.taxi

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("taxi")
class TaxiController {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "title")
        return "taxi/index"
    }
}