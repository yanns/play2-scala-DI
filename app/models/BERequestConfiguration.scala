package models

/**
 * request configuration for Wikipedia
 */
trait BERequestConfiguration {

  def url: String
  def userAgent: String

}
