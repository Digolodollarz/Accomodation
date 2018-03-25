package tech.diggle.apps.accomodation.house

interface HouseService {
    fun add(house: House): House
    fun get(id: Long): House
    fun update(house: House): House
    fun getAll(): List<House>
    fun create(form: HouseForm): House
    fun get(page: Int, size: Int): List<House>
}
