package utils

object StringUtils {
  
  def toSessionParam(key: String): String = { 
    return "${" + key + "}"
  }
  
}