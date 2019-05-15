package config

object Headers {

  var token = GlobalVars.getAuthToken

  val commonHeader = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Content-Type" -> "application/json",
    "user-key" -> token
  )

  
}
