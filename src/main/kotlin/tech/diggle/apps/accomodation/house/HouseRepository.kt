package tech.diggle.apps.accomodation.house

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

interface HouseRepository : PagingAndSortingRepository<House, Long> {
    fun findByAddressContains(address: String, pageRequest: Pageable): Page<House>
    fun findByActiveTrue(pageRequest: Pageable): Page<House>
    fun findByAvailableTrueAndActiveTrue(pageRequest: Pageable): Page<House>
}