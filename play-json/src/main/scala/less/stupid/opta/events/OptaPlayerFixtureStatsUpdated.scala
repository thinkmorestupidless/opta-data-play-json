package less.stupid.opta.events

import play.api.libs.json._

class OptaPlayerFixtureStatsUpdated(val playerId: String,
                                    val fixtureId: String) {

}

object OptaPlayerFixtureStatsUpdated {

  implicit val opfsuReads: Reads[OptaPlayerFixtureStatsUpdated] = new Reads[OptaPlayerFixtureStatsUpdated] {

    def reads(json: JsValue): JsResult[OptaPlayerFixtureStatsUpdated] =
      JsSuccess(
        new OptaPlayerFixtureStatsUpdated(
          (json \ "playerId").get.as[String],
          (json \ "fixtureId").get.as[String]
        )
      )
  }

  implicit val opfsuWrites: Writes[OptaPlayerFixtureStatsUpdated] = new Writes[OptaPlayerFixtureStatsUpdated] {

    def writes(evt: OptaPlayerFixtureStatsUpdated): JsValue =
      Json.obj(
        "playerId" -> evt.playerId,
        "fixtureId" -> evt.fixtureId
      )
  }

  implicit val format: Format[OptaPlayerFixtureStatsUpdated] = Format(opfsuReads, opfsuWrites)
}
