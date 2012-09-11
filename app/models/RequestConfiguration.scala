package models

/**
 * request configuration for Wikipedia
 */
trait RequestConfiguration {

  def url: String
  def userAgent: String

}
