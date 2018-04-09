package tech.diggle.apps.accomodation.house

import org.springframework.web.multipart.MultipartFile
import tech.diggle.apps.accomodation.owner.Owner

class HouseForm() {
    var id: Long? = null
    var title: String? = null
    var address: String? = null
    var location: String? = null
    var capacity: Int? = null
    var occupied: Int? = null
    var rooms: Int? = null
    var images: MutableList<MultipartFile> = mutableListOf()
    var owner: Owner? = null
    var price: Float? = null
    var active: Boolean? = true
    var available: Boolean? = true

    constructor(house: House) : this() {
        this.id = house.id
        this.title = house.title
        this.address = house.address
        this.location = house.location
        this.capacity = house.capacity
        this.occupied = house.occupied
        this.rooms = house.rooms
        this.owner = house.owner
        this.price = house.price
        this.available = house.available
        this.active = if (house.available != null) {
            house.available
        } else true
    }
}