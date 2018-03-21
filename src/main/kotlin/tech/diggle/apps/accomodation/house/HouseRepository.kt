package tech.diggle.apps.accomodation.house

import org.springframework.data.repository.PagingAndSortingRepository

interface HouseRepository : PagingAndSortingRepository<House, Long> {
    fun findByAddressContains(address: String): List<House>
}