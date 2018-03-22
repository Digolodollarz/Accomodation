package tech.diggle.apps.accomodation.owner

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*

@Entity
class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @NotEmpty
    var name: String = ""

    @NotEmpty
    var email: String = ""

    @NotEmpty
    var phone: String = ""

    @Column(name = "alt_phone")
    var phone2: String? = null
}