package less.stupid.opta.commands

import java.time.Instant

import less.stupid.opta.Position
import play.api.libs.json.{Format, Json}

case class UpdateOptaPlayerInfo(position: Position,
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

object UpdateOptaPlayerInfo {

  implicit val format: Format[UpdateOptaPlayerInfo] = Json.format
}

