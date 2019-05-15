package actions

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config._
import config.GlobalNames._
import io.gatling.core.action.builder._
import utils.StringUtils._


object GetCatogories {

  var token = GlobalVars.getAuthToken
  
 
    def GetCatogoriesAction(endpoint: String): ActionBuilder = {
    return http("Get Catogories")
        .get("https://developers.zomato.com/api/v2.1/categories")
        .headers(Headers.commonHeader)
        .check(status.is(200))
        .check(jsonPath("$").saveAs("Get_catogories_response"))
        .check(jsonPath("$.categories[*]").count.is(13))
        
         
  }
  def GetCitiesAction(endpoint: String): ActionBuilder = {
    return http("Get Cities for supported country")
        .get("https://developers.zomato.com/api/v2.1/cities?q=NewYorkCity")
        .headers(Headers.commonHeader)
        .check(status.is(200))
        .check(jsonPath("$").saveAs("Get_cities_response"))
        .check(jsonPath("$.status").is("success"))
        .check(jsonPath("$.location_suggestions").exists)
        .check(regex("\"id\":280"))
        .check(regex("\"country_id\":216"))  
        .check(regex("\"country_name\":\"United States\""))
        .check(regex("\"should_experiment_with\":0"))
        .check(regex("\"discovery_enabled\":0"))  
        .check(regex("\"has_new_ad_format\":0"))
        .check(regex("\"is_state\":0"))  
        .check(regex("\"state_id\":103"))
        .check(regex("\"state_name\":\"New York State\""))  
        .check(regex("\"name\":\"New York City, NY\"").exists)
         .check(regex("\"name\":\"Long Island, NY\""))
        .check(regex("\"name\":\"Westchester County, NY\""))
        .check(regex("\"name\":\"Buffalo, NY\""))
        .check(regex("\"name\":\"Hudson Valley, NY\""))
        .check(regex("\"name\":\"Albany, New York, NY\""))
        .check(regex("\"name\":\"Rochester, New York, NY\""))
        .check(regex("\"name\":\"Syracuse, NY\""))
        .check(regex("\"name\":\"Utica, NY\""))
        .check(regex("\"name\":\"Finger Lakes Region, NY\""))
        
        //similarly we can assert remaining loops here.
  }
  def GetUnsupportedCitiesAction(endpoint: String): ActionBuilder = {
    return http("Get Cities for unsupported country")
        .get("https://developers.zomato.com/api/v2.1/cities")
        .headers(Headers.commonHeader)
        .header("q", "Ireland")       
        .check(status.is(200))
        .check(jsonPath("$").saveAs("Get_cities_response"))
        .check(jsonPath("$.location_suggestions[*]").count.is(0))
        .check(jsonPath("$.status").is("success"))
        .check(regex("\"has_more\":0"))
        .check(regex("\"has_total\":0"))  
 
  }
}
