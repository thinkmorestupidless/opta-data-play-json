package less.stupid.opta.commands

import play.api.libs.json._

class UpdateOptaPlayerFixtureStats(val fixtureId: String) {

  override def equals(obj: scala.Any): Boolean = super.equals(obj)
}

object UpdateOptaPlayerFixtureStats {

  implicit val uopfsReads: Reads[UpdateOptaPlayerFixtureStats] = new Reads[UpdateOptaPlayerFixtureStats] {

    def reads(json: JsValue): JsResult[UpdateOptaPlayerFixtureStats] =
      JsSuccess(
        new UpdateOptaPlayerFixtureStats(
          (json \ "fixtureId").get.as[String]
        )
      )
  }

  implicit val uopfsWrites: Writes[UpdateOptaPlayerFixtureStats] = new Writes[UpdateOptaPlayerFixtureStats] {

    def writes(evt: UpdateOptaPlayerFixtureStats): JsValue =
      Json.obj(
        "fixtureId" -> evt.fixtureId
      )
  }

  implicit val format: Format[UpdateOptaPlayerFixtureStats] = Format(uopfsReads, uopfsWrites)
}
