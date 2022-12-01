package ru.itis.decoder.util

import java.io.File

fun getFanoDictionary(filePath: String): MutableMap<String, Double> {
    val list = File(filePath).useLines { it.toList() }
    val map = mutableMapOf<String, Double>()
    val probabilityList  = list[1].split(" ").map { it.toDouble() }
    for ((index,  line) in list[0].split(" ").withIndex())  {
        map[line] = probabilityList[index]
    }
    return map
}