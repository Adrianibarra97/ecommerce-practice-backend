package ecommerce.backend.repository

import ecommerce.backend.domain.User


open class UserRepository { // : CrudRepository<User, Int> {
  
  private val objects: MutableList<User> = mutableListOf()
  
  fun save(user: User) {
    this.objects.add(user)
  }
  
  fun findByUsername(username: String): User? {
    return this.objects.find {
      it.username == username
    }
  }
}