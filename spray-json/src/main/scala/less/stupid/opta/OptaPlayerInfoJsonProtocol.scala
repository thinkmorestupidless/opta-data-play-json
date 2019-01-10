package less.stupid.opta

import java.time.Instant
import spray.json._

trait OptaPlayerInfoJsonProtocol extends DefaultJsonProtocol
  with PositionSupport
  with InstantJsonSupport {

  implicit object OptaPlayerInfoFormat extends RootJsonFormat[OptaPlayerInfo] {

    def write(info: OptaPlayerInfo) = JsObject(
      "playerId" -> JsString(info.playerId),
      "fullName" -> JsString(info.fullName),
      "firstName" -> JsString(info.firstName),
      "lastName" -> JsString(info.lastName),
      "position" -> JsString(info.position.toString),
      "birthday" -> JsNumber(info.birthday.toEpochMilli),
      "joinDate" -> JsNumber(info.joinDate.toEpochMilli),
      "birthPlace" -> JsString(info.birthPlace),
      "nationality" -> JsString(info.nationality),
      "weight" -> JsNumber(info.weight),
      "height" -> JsNumber(info.height),
      "jerseyNo" -> JsNumber(info.jerseyNo),
      "country" -> JsString(info.country),
      "realPosition" -> JsString(info.realPosition),
      "realPositionSide" -> JsString(info.realPositionSide),
      "preferredFoot" -> JsString(info.preferredFoot)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields(
        "playerId",
        "fullName",
        "firstName",
        "lastName",
        "position",
        "birthday",
        "joinDate",
        "birthPlace",
        "nationality",
        "weight",
        "height",
        "jerseyNo",
        "country",
        "realPosition",
        "realPositionSide",
        "preferredFoot") match {
        case Seq(JsString(playerId), JsString(fullName), JsString(firstName), JsString(lastName), position, birthday, joinDate, JsString(birthPlace), JsString(nationality), JsNumber(weight), JsNumber(height), JsNumber(jerseyNo), JsString(country), JsString(realPosition), JsString(realPositionSide), JsString(preferredFoot)) =>
          OptaPlayerInfo(playerId, fullName, firstName, lastName, position.convertTo[Position], birthday.convertTo[Instant], joinDate.convertTo[Instant], birthPlace, nationality, weight.intValue(), height.intValue(), jerseyNo.intValue(), country, realPosition, realPositionSide, preferredFoot)
        case other => deserializationError(s"Expected OptaPlayerInfo, but got: $other")
      }
    }
  }
}
