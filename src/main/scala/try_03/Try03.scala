package try_03

import share._

// domain service

object DomainService {
  def apply(order: Order, item: () => Item): Boolean = {
    order.isOk && item().isOk
  }
}

// application service

object ApplicationService {
  private val orders = OrderRepositoryImpl
  private val items = ItemRepositoryImpl

  def apply(userId: Int): Boolean = {
    val order = orders.findOne(userId)
    val item = () => items.findOne(userId)

    DomainService(order, item)
  }
}
