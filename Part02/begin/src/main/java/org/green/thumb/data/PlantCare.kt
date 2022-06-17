package org.green.thumb.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
class PlantCare(
    val description: String = "",
    val date: LocalDate = LocalDate.MIN,
) : Parcelable