package org.green.thumb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

/**
 * What can be done for a plant
 * @param plantCareId Identifier for the plant care log entry.
 * @param description Action that can be done for the plant, one of: watering, fertilizing, leaf cleaning, prunning, repotting.
 * @param date The last time the specific action has been performed for the plant.
 * @param plant The plant for which the action has been performed.
 */
@Entity(foreignKeys = [ForeignKey(
    entity = Plant::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("plant"),
    onDelete = ForeignKey.CASCADE
)])
class PlantCare(
    @PrimaryKey @ColumnInfo(name = "plantCareId") val plantCareId: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "date") val date: LocalDate = LocalDate.MIN,
    @ColumnInfo(index = true) val plant: String,
) {
}
//https://stackoverflow.com/questions/47511750/how-to-use-foreign-key-in-room-persistence-library
//@Entity(
//    foreignKeys = [ForeignKey(
//        entity = Artist::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("artist"),
//        onDelete = ForeignKey.CASCADE
//    )]
//)
//data class Album(
//    @PrimaryKey
//    val albumId: String,
//    val name: String,
//    @ColumnInfo(index = true)
//    val artist: String,
//)