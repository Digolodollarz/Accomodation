package tech.diggle.apps.accomodation.house

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import tech.diggle.apps.accomodation.file.FileUploadService
import javax.servlet.http.HttpServletRequest

@Controller
class HouseController(@Autowired val service: HouseService,
                      @Autowired val fileUploadService: FileUploadService) {
    @GetMapping("house/{id}")
    fun getHouse(@PathVariable id: Long): ModelAndView {
        val modelAndView = ModelAndView("house/house")
        val house = service.get(id)
        modelAndView.addObject("house", house)
        return modelAndView
    }

    @GetMapping("admin/house/create")
    fun getCreateForm(model: Model): String {
        model.addAttribute("house", HouseForm())
        return "house/create"
    }

    @PostMapping("/admin/house/create")
    fun postCreateForm(@ModelAttribute form: HouseForm, model: Model,
                       bindingResult: BindingResult,
                       request: HttpServletRequest): String {
        if (bindingResult.hasErrors()) return "house/create"

        val house = service.create(form)
        model.addAttribute("house", house)

        val url = request.requestURL
        val uri = request.requestURI
        val ctx = request.contextPath
        val base = url.substring(0, url.length - uri.length + ctx.length)

        return """redirect:$base/house/${house.id}/"""
    }

    @GetMapping("images/{house}/{fileId:.+}")
    @ResponseBody
    fun getImage(@PathVariable("house") houseId: Long,
                 @PathVariable("fileId") fileId: Long) = fileUploadService.getFile(fileId)

//    @GetMapping("images/{house}/{filename:.+}")
//    @ResponseBody
//    fun getHouseImage(@PathVariable("house") houseId: Long,
//                      @PathVariable("filename") filename: String) = fileUploadService.getFile(houseId, filename)

    @GetMapping("houses")
    fun listHouses(model: Model): String {
        val houses: List<House> = service.getAll()
        model.addAttribute("houses", houses)
        return "house/houses"
    }
}