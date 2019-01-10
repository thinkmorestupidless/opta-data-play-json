package less.stupid.opta

import java.time.Instant

sealed trait Position

case object Goalkeeper extends Position
case object Defender extends Position
case object Midfielder extends Position
case object Forward extends Position

case class OptaPlayerInfo(playerId: String,
                          fullName: String,
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
                          preferredFoot: String)
