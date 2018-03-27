package tech.diggle.apps.accomodation.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.PageRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import tech.diggle.apps.accomodation.role.RoleRepository


@Service("userService")
class UserServiceImpl : UserService {

    @Qualifier("userRepository")
    @Autowired
    private val userRepository: UserRepository? = null
    @Qualifier("roleRepository")
    @Autowired
    private val roleRepository: RoleRepository? = null
    @Autowired
    private val bCryptPasswordEncoder: BCryptPasswordEncoder? = null

    override fun findUserByEmail(email: String): User {
        return userRepository!!.findByEmail(email)
    }

    override fun saveUser(user: User): User {
        user.password = bCryptPasswordEncoder!!.encode(user.password!!)
        user.active = true
        val userRole = roleRepository!!.findByRole("USER")
        user.roles = mutableSetOf(userRole)
        return userRepository!!.save(user)
    }

    fun addRole(roleName: String) {

    }

    override fun getUsers(size: Int, page: Int): List<User> {
        return this.userRepository!!.findByActiveTrue(PageRequest(page, size))//.content
    }

    override fun delete(userId: Long) {
        val user = userRepository!!.findOne(userId)
        user.active = false
        userRepository.save(user)
    }
}