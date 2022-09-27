package flightweather.domain

import java.time.ZonedDateTime

trait Validatable {
    def validate() : Set[String]
}

// We need a way to break createdAt into two columns in the database.
// One for the datetime value itself, the other one for the UTC offset.
// Or probably in the complete datetime string in ISO format compelete with UTC offset.
// This enables querying in both ways; UTC comparison and time of day comparison.
sealed case class EntityHeader(
    val id : Option[Int] = None, val createdAt: Option[ZonedDateTime] = None, 
    val updatedAt: Option[ZonedDateTime] = None, val deletedAt: Option[ZonedDateTime] = None
)

abstract class Entity(header: EntityHeader) extends Validatable

sealed abstract class StreamProcessingStatus(name: String)
object StreamProcessingStatus {
    case object Undefined extends StreamProcessingStatus("Undefined")
    case object Running extends StreamProcessingStatus("Running")
    case object Success extends StreamProcessingStatus("Success")
    case object Failed extends StreamProcessingStatus("Failed")
    case object Partial extends StreamProcessingStatus("Partial")
}

case class ChunkProcessingReport(successCount: Int, errorCount: Int) //value object

case class StreamProcessingReport(
    header: EntityHeader, successCount: Int, errorCount: Int, reference: String, 
    provider: Option[String], format: Option[String], path: String, status: StreamProcessingStatus, 
) extends Entity(header) {
    override def validate(): Set[String] = Set[String]()
}