package ecommerce.backend.domianTest

import ecommerce.backend.domain.User
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.bigdecimal.shouldBeZero
import io.kotest.matchers.shouldBe

class UserTest : DescribeSpec({
  
  isolationMode = IsolationMode.InstancePerTest
  
  // DATA
  
  // Users
  val adrian: User = User()
  
  describe("User test.") {
    it("User get total monetary successfully.") {
      //Act
      adrian.money = 200.toBigDecimal()
      
      //Assert
      adrian.totalMonetary().shouldBe(200.toBigDecimal())
    }
    
    it("User get total monetary and is 0.") {
      //Act
      adrian.money = 0.toBigDecimal()
      
      //Assert
      adrian.totalMonetary().shouldBeZero()
    }
  }
})