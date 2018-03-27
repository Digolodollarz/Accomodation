package tech.diggle.apps.accomodation.user

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.data.annotation.Transient
import tech.diggle.apps.accomodation.role.Role

import javax.persistence.*

@Entity
@Table(name = "user")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    var id: Long = 0

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    var email: String? = null

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Transient
    var password: String? = null

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    var name: String? = null

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    var lastName: String? = null

    @Column(name = "active")
    var active: Boolean = true

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "user_role", joinColumns = arrayOf(JoinColumn(name = "user_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "role_id")))
    var roles: MutableSet<Role>? = null

    val isAdmin: Boolean
        get() {
            var `is` = false
            for (role in roles!!) {
                if (role.role == "ADMIN")
                    `is` = true
            }
            return `is`
        }
}