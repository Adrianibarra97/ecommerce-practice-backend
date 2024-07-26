package ecommerce.backend.service

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class UserService {
  
  //@Autowired
  //private lateinit var repository: UserRepository
  
  fun getMoneyByUserId(username: String): BigDecimal {
    //val user: User = this.repository.findByUsername(username)
    //return user.money
    return 200.0.toBigDecimal()
  }
}