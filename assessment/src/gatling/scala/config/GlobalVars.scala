package config

import io.gatling.core.Predef._
import scala.concurrent.duration._

object GlobalVars {
  
  def getEnv: String = {
    var environment = System.getenv("ENV")
    return environment
  }
  def getAuthToken: String = {
    var token = System.getenv("TOKEN")
    return token
  }
  
}
