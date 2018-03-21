package tech.diggle.apps.accomodation.house

import org.springframework.web.multipart.MultipartFile

class HouseForm {
    var id: Long = 0
    var title: String = ""
    var address: String = ""
    var capacity: Int = 0
    var occupied: Int = 0
    var rooms: Int = 0
    var images: MutableList<MultipartFile> = mutableListOf()
}