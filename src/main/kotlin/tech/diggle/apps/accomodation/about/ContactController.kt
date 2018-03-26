package tech.diggle.apps.accomodation.about

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("contact")
class ContactController {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "Contact Us")
        return "contact"
    }
}