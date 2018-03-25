package tech.diggle.apps.accomodation.shop

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("shop")
class ShopController {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "All the shops")
        return "shop/index"
    }
}