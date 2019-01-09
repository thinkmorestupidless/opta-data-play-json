package less.stupid.opta

import java.time.Instant
import play.api.libs.json._

sealed trait Position

object Position {

  implicit val pReads: Reads[Position] = new Reads[Position] {

    def reads(json: JsValue): JsResult[Position] =
      JsSuccess(
        json.as[String] match {
          case "Goalkeeper" => Goalkeeper
          case "Defender" => Defender
          case "Midfielder" => Midfielder
          case "Forward" => Forward
        }
      )
  }

  implicit val pWrites: Writes[Position] = new Writes[Position] {

    def writes(position: Position): JsValue =
      JsString(position.toString)
  }

  implicit val format: Format[Position] = Format(pReads, pWrites)
}

case object Goalkeeper extends Position
case object Defender extends Position
case object Midfielder extends Position
case object Forward extends Position

case class OptaPlayerInfo(fullName: String,
                          firstName: String,
                          lastName: String,
                          position: Position,
                          birthday: Instant,
                          joinDate: Instant,
                          birthPlace: String,
                          nationality: String,
                          weight: Int,
                          height: Int,
                          jerseyNo: Int,
                          country: String,
                          realPosition: String,
                          realPositionSide: String,
                          preferredFoot: String) {

}

object OptaPlayerInfo {

  implicit val format: Format[OptaPlayerInfo] = Json.format
}
