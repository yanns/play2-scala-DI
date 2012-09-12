package models.cake

import models.BERequest


/**
 * defines a dependency to [[models.BERequest]]
 */
trait BERequestComponent {

  def request: BERequest

}
