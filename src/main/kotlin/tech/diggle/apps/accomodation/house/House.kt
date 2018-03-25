package tech.diggle.apps.accomodation.house

import org.hibernate.validator.constraints.NotEmpty
import tech.diggle.apps.accomodation.owner.Owner
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @Column
    @NotEmpty
    @NotNull
    var title: String = ""

    @Column
    @NotEmpty
    var address: String = ""

    @Column
    @NotNull
    var location: String = ""

    @Column
    var capacity: Int = 0

    @Column
    var occupied: Int = 0

    @Column
    var rooms: Int = 0

    @ElementCollection(fetch = FetchType.EAGER)
    var images: MutableList<Long> = mutableListOf()

    @ManyToOne
    var owner: Owner? = null

    @Column
    var price: Float? = 0f
}