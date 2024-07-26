package ecommerce.backend.controller

import ecommerce.backend.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class UserController {
  
  @Autowired
  private lateinit var userService: UserService
  
  @GetMapping("/user/user-money")
  @Operation(summary = "Return user money")
  fun getUserMoney() : String {
    return this.userService.getMoneyByUserId("").toString()
  }
}