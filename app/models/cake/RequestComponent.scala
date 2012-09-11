package models.cake

import models.Request


/**
 * defines a dependency to [[models.Request]]
 */
trait RequestComponent {

  def request: Request

}
