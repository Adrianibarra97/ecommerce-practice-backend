package ecommerce.backend.bootstrap

import ecommerce.backend.domain.User
import ecommerce.backend.repository.UserRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service
class ApplicationBootstrap() : InitializingBean {
  
  @Autowired
  lateinit var userRepository: UserRepository
  
  // Users
  val adrian: User = User("", "", 23.toBigDecimal())
  
  override fun afterPropertiesSet() {}
  
  @Bean
  fun setUserRepository(): UserRepository = UserRepository().apply {
    this.save(adrian)
  }
}