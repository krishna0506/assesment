package simulations

/**
 * Created by
 */

import scala.concurrent.duration._
import io.gatling.core.Predef._
import scenarios._


class GetCatogoriesSimulation extends Simulation {



  setUp(//GetCatogoriesScenario.getCatagories.inject(nothingFor(10 seconds), atOnceUsers(1)),
      GetCatogoriesScenario.getCities.inject(nothingFor(10 seconds), atOnceUsers(1)))
    .assertions(global.successfulRequests.percent.is(100))
}