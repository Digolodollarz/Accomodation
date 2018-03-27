package tech.diggle.apps.accomodation.user

interface UserService {
    fun findUserByEmail(email: String): User
    fun saveUser(user: User): User
    fun getUsers(size: Int, page: Int): List<User>
    fun delete(userId: Long)
}