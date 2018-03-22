package tech.diggle.apps.accomodation.file

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class DBImage{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @Column(name = "house_id")
    @NotNull
    var houseId: Long? = null
    @NotNull
    var byteArray: ByteArray? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DBImage

        if (houseId != other.houseId) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = houseId!!.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }
}