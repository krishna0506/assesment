package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure._
import actions._
import config._


object GetCatogoriesScenario {

  val endpoint = GlobalVars.getEnv;

  def getCatagories(): ScenarioBuilder = {

    return scenario("Get catogories")  
          .exec(GetCatogories.GetCatogoriesAction(endpoint))
          .exec( session => {
     println( "GET_CATEGORIES:" )
     println( session( "Get_catogories_response" ).as[String] )
     session
    })
  }
  
  def getCitiesUnsupported(): ScenarioBuilder = {

    return scenario("Get cities for unsupported countries")  
          .exec(GetCatogories.GetUnsupportedCitiesAction(endpoint))
          .exec( session => {
     println( "GET_CITIES:" )
     println( session( "Get_cities_response" ).as[String] )
     session
    })
  }
   def getCitiesSupported(): ScenarioBuilder = {

    return scenario("Get citites for supported country")  
          .exec(GetCatogories.GetCitiesAction(endpoint))
          .exec( session => {
     println( "GET_CITIES:" )
     println( session( "Get_cities_response" ).as[String] )
     session
    })
  }

}
