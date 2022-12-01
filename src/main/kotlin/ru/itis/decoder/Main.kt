package ru.itis.decoder

import ru.itis.decoder.fano.decodeFano
import ru.itis.decoder.util.getFanoDictionary
import java.util.*

const val PATH_FILE = "/Users/m.yusupov/IdeaProjects/Decoder/src/main/resources/input.txt"

fun main(args: Array<String>) {
    print("Input your text: ")
    val text: String = Scanner(System.`in`).nextLine()
    println("Decoded text: ${decodeFano(text, getFanoDictionary(PATH_FILE))}")
}