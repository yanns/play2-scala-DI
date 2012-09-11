package models.cake

import models.RequestConfiguration

/**
 * defines a dependency to [[models.RequestConfiguration]]
 */
trait RequestConfigurationComponent {

  def requestConfiguration: RequestConfiguration
}
