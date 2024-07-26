package ecommerce.backend.bootstrap

import ecommerce.backend.domain.User
import ecommerce.backend.repository.UserRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicationBootstrap() : InitializingBean {
  
  @Autowired
  lateinit var userRepository: UserRepository
  
  // Users
  val adrian: User = User()
  
  override fun afterPropertiesSet() {
    
    // Users
    adrian.apply {
      this.username = "adri97@gmail.com"
      this.password = "adrian1234"
      this.money = 130002323.toBigDecimal()
    }
    
    userRepository.apply {
      this.save(adrian)
    }
  }
}