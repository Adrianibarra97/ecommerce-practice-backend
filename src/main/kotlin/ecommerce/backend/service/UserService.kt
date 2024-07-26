package ecommerce.backend.service

import ecommerce.backend.domain.User
import ecommerce.backend.dto.UserDTO
import ecommerce.backend.repository.UserRepository
import ecommerce.backend.util.DataValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
  
  @Autowired
  private lateinit var repository: UserRepository
  
  fun getMoneyByUserId(username: String): UserDTO {
    DataValidator.someStringIsEmpty(listOf(username))
    val user: User = this.repository.findByUsername(username)
    return UserDTO(
      user.id,
      user.username!!,
      user.money.toDouble()
    )
  }
}