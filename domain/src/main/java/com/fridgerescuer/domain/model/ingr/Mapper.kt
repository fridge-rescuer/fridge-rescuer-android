package com.fridgerescuer.domain.model.ingr

import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun mapperToIngrSample(ingrs: List<Ingr>): List<IngrSample> {
    return ingrs.toList().map {
        IngrSample(
            it.id,
            it.ingr_name,
            toRemainingDate(it.exp_date, it.use_date),
            it.ingr_image
        )
    }
}

private fun toRemainingDate(stringExp: String, stringUse: String?): String {

    val expDate: LocalDate = LocalDate.parse(stringExp, DateTimeFormatter.ISO_LOCAL_DATE)
    val today: LocalDate = LocalDate.now()

    if (stringUse == null) {
        val diffDays: String = Duration.between(expDate.atStartOfDay(), today.atStartOfDay()).toDays().toString()

        return if (expDate < today) "D+$diffDays"
        else "D-$diffDays"
    }
    else {
        val useDate: LocalDate = LocalDate.parse(stringUse, DateTimeFormatter.ISO_LOCAL_DATE)

        if (expDate >= today) {
            val diffDays: String = Duration.between(expDate.atStartOfDay(), today.atStartOfDay()).toDays().toString()
            val diffDaysUse: String = Duration.between(expDate.atStartOfDay(), useDate.atStartOfDay()).toDays().toString()
            return "D-$diffDays ($diffDaysUse)"
        }
        else if (useDate >= today) {
            val diffDays: String = Duration.between(useDate.atStartOfDay(), today.atStartOfDay()).toDays().toString()
            return "D-$diffDays"
        }
        else {
            val diffDays: String = Duration.between(useDate.atStartOfDay(), today.atStartOfDay()).toDays().toString()
            return "D+$diffDays"
        }
    }
}