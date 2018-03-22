package tech.diggle.apps.accomodation.house

import org.springframework.web.multipart.MultipartFile
import tech.diggle.apps.accomodation.owner.Owner

class HouseForm {
    var id: Long? = null
    var title: String? = null
    var address: String? = null
    var location: String? = null
    var capacity: Int? = null
    var occupied: Int? = null
    var rooms: Int? = null
    var images: MutableList<MultipartFile> = mutableListOf()
    var owner: Owner? = null
}