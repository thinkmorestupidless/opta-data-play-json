package less.stupid.opta.events

import java.time.Instant

import less.stupid.opta.Position
import play.api.libs.json.{Format, Json}

case class OptaPlayerInfoUpdated(playerId: String,
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

object OptaPlayerInfoUpdated {

  implicit val format: Format[OptaPlayerInfoUpdated] = Json.format
}

