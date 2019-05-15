package simulations

/**
 * Created by
 */

import scala.concurrent.duration._
import io.gatling.core.Predef._
import scenarios._


class GetCatogoriesSimulation extends Simulation {



  setUp(GetCatogoriesScenario.getCatagories.inject(nothingFor(10 seconds), atOnceUsers(1)), //this will run get categories case
      GetCatogoriesScenario.getCities.inject(nothingFor(10 seconds), atOnceUsers(1))) //this will run get cities use cases.
    .assertions(global.successfulRequests.percent.is(100))
}
