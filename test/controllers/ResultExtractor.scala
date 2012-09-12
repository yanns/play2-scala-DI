package controllers

import play.api.mvc.{AsyncResult, Result}

class ResultExtractor {

  /**
   * for asynchronous result, wait for end result
   */
  def getResult(result: Result): Result = result match {
    case ar: AsyncResult => ar.result.await.get
    case r => r
  }

}
object ResultExtractor {
  implicit def getResult(result: Result): Result = new ResultExtractor().getResult(result)
}
