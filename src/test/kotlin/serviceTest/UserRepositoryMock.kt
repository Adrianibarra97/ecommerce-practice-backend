package serviceTest

import ecommerce.backend.domain.User
import ecommerce.backend.repository.UserRepository
import java.util.*

class UserRepositoryMock : UserRepository {
  
  private val users: MutableList<User> = mutableListOf()
  override fun findByUsername(username: String): User =
    this.users[0]
  
  override fun <S : User?> save(entity: S & Any): S & Any {
    this.users.add(entity)
    return entity
  }
  
  override fun <S : User?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
    TODO("Not yet implemented")
  }
  
  override fun findAll(): MutableIterable<User> {
    TODO("Not yet implemented")
  }
  
  override fun findAllById(ids: MutableIterable<Int>): MutableIterable<User> {
    TODO("Not yet implemented")
  }
  
  override fun count(): Long {
    TODO("Not yet implemented")
  }
  
  override fun delete(entity: User) {
    TODO("Not yet implemented")
  }
  
  override fun deleteAllById(ids: MutableIterable<Int>) {
    TODO("Not yet implemented")
  }
  
  override fun deleteAll(entities: MutableIterable<User>) {
    TODO("Not yet implemented")
  }
  
  override fun deleteAll() {
    TODO("Not yet implemented")
  }
  
  override fun deleteById(id: Int) {
    TODO("Not yet implemented")
  }
  
  override fun existsById(id: Int): Boolean {
    TODO("Not yet implemented")
  }
  
  override fun findById(id: Int): Optional<User> {
    TODO("Not yet implemented")
  }
}