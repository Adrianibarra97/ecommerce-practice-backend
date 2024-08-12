package ecommerce.backend.domain

import ecommerce.backend.dto.UserDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "base_user")
class User {
  
  companion object {
    fun fromJSON(userDTO: UserDTO): User =
      User().apply {
        this.id = userDTO.id
        this.username = userDTO.username
        this.money = userDTO.money.toBigDecimal()
      }
  }
  
  @Id
  @GeneratedValue
  var id: Int = 0
  
  @Column(length = 50)
  var username: String = ""
  
  @Column(length = 50)
  var password: String = ""
  
  @Column
  var money: BigDecimal = 0.toBigDecimal()
  
  fun totalMonetary() : BigDecimal = this.money
}