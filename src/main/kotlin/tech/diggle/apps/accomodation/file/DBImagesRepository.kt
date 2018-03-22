package tech.diggle.apps.accomodation.file

import org.springframework.data.jpa.repository.JpaRepository

interface DBImagesRepository: JpaRepository<DBImage,Long>{
    fun findByHouseId(houseId: Long): DBImage
}