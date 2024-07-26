package ecommerce.backend.repository

import ecommerce.backend.domain.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Int> {
  
  fun findByUsername(username: String): User
}