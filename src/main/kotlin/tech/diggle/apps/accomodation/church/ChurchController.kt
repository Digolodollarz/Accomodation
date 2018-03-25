package tech.diggle.apps.accomodation.church

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("church")
class ChurchController {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "All Church Stuff")
        return "church/index"
    }
}