package tech.diggle.apps.accomodation.user

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository("userRepository")
interface UserRepository : PagingAndSortingRepository<User, Long> {
    fun findByEmail(email: String): User
    fun findByActiveTrue(page: Pageable): List<User>
}