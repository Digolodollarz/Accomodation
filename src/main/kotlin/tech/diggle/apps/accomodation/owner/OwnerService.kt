package tech.diggle.apps.accomodation.owner

interface OwnerService {
    fun get(id: Long): Owner
    fun getOrAdd(o: Owner): Owner
    fun add(o: Owner): Owner
    fun update(o: Owner): Owner
}