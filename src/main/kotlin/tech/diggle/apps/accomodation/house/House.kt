package tech.diggle.apps.accomodation.house

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*

@Entity
class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @Column
    @NotEmpty
    var title: String = ""

    @Column
    @NotEmpty
    var address: String = ""

    @Column
    var capacity: Int = 0

    @Column
    var occupied: Int = 0

    @Column
    var rooms: Int = 0

    @ElementCollection
    var images: MutableList<String> = mutableListOf()
}