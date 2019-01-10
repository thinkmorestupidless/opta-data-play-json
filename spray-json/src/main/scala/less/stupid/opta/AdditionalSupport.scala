package less.stupid.opta

import java.time.Instant

import spray.json.{DefaultJsonProtocol, JsNumber, JsString, JsValue, JsonFormat, deserializationError}

trait InstantJsonSupport extends DefaultJsonProtocol {
  implicit object InstantFormat extends JsonFormat[Instant] {
    def write(instant: Instant) = JsNumber(instant.toEpochMilli)

    def read(json: JsValue): Instant = json match {
      case JsNumber(value) ⇒ Instant.ofEpochMilli(value.toLong)
      case other           ⇒ deserializationError(s"Expected Instant as JsNumber, but got: $other")
    }
  }
}

trait PositionSupport extends DefaultJsonProtocol {

  implicit object PositionFormat extends JsonFormat[Position] {

    def write(position: Position) = JsString(position.toString)

    def read(json: JsValue): Position = json match {
      case JsString(value) => {
        value match {
          case "Goalkeeper" => Goalkeeper
          case "Defender" => Defender
          case "Midfielder" => Midfielder
          case "Forward" => Forward
        }
      }
      case other => deserializationError(s"expected a Player Position but found $other")
    }
  }
}
