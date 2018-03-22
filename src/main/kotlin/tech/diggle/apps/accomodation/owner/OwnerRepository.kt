package tech.diggle.apps.accomodation.owner

import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<Owner, Long> {
    fun findByEmail(email: String): Owner
}