package tech.diggle.apps.accomodation.user

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/user")
class UserController(val service: UserService) {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "All Users")
        model.addAttribute("users", service.getUsers(25, 0))
        return "user/index"
    }

    @GetMapping("new")
    fun getForm(model: Model): String {
        model.addAttribute("title", "New User")
        model.addAttribute("user", User())
        return "user/create"
    }

    @PostMapping("new")
    fun createUser(@ModelAttribute user: User, model: Model,
                   bindingResult: BindingResult,
                   request: HttpServletRequest): String {
        if (bindingResult.hasErrors()) return "user/create"

        service.saveUser(user)

        val url = request.requestURL
        val uri = request.requestURI
        val ctx = request.contextPath
        val base = url.substring(0, url.length - uri.length + ctx.length)

        return """redirect:$base/user/"""
    }

    @GetMapping("disable/{userId}")
    fun disable(@PathVariable("userId") userId: Long,
                request: HttpServletRequest): String {
        val user = service.delete(userId)
        val url = request.requestURL
        val uri = request.requestURI
        val ctx = request.contextPath
        val base = url.substring(0, url.length - uri.length + ctx.length)
        return """redirect:$base/user/"""
    }
}