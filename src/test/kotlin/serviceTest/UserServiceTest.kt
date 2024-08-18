package serviceTest

import ecommerce.backend.domain.User
import ecommerce.backend.dto.UserDTO
import ecommerce.backend.repository.UserRepository
import ecommerce.backend.service.UserService
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class UserServiceTest : DescribeSpec({
  
  isolationMode = IsolationMode.InstancePerTest
  
  // DATA
  
  // Users
  val adrian: User = User().apply {
    this.id = 1
    this.username = "adrian@gmail.com"
    this.password = "password123"
    this.money = 500.0.toBigDecimal()
  }
  
  // Services
  val userService: UserService = UserService().apply {
    this.repository = UserRepositoryMock().apply {
      this.save(adrian)
    }
  }
  
  describe("UserService test.") {
    it("Get money of the user.") {
      //Act
      
      val userDTO: UserDTO = userService.getMoneyByUserId("adrian@gmail.com")
      
      //Assert
      userDTO.money.shouldBe(500.0)
    }
  }
})

