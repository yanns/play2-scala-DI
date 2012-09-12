package models.cake

import models.BERequestConfiguration

/**
 * defines a dependency to [[models.BERequestConfiguration]]
 */
trait BERequestConfigurationComponent {

  def requestConfiguration: BERequestConfiguration
}
