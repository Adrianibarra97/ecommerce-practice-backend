package ecommerce.backend.domain

import java.math.BigDecimal

class User(
  var username: String,
  var password: String,
  var money: BigDecimal
) {
  
  fun totalMonetary() : BigDecimal = this.money
}