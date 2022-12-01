package ru.itis.decoder.fano

import java.lang.StringBuilder

fun decodeFano(text: String, map: MutableMap<String, Double>): String {
    val codeMap = getCodeMap(map).entries.associateBy({ it.value }) { it.key }
    codeMap.forEach(System.out::println)
    val resultStr = StringBuilder("")
    var input = text
    while(input.isNotEmpty()) {
        val prefix = getFirstPrefix(codeMap, input)
        resultStr.append(codeMap[prefix])
        input = input.substring(prefix.length)
    }
    return resultStr.toString()
}

private fun getCodeMap( map: MutableMap<String, Double>, code: String = ""): Map<String, String> {
    if(map.isEmpty()) error("Dictionary couldn't be empty")
    if(map.size == 1) return mutableMapOf(map.keys.first() to code)
    val firstMap = mutableMapOf<String, Double>()
    var sumProbability = 0.0
    val averageProbability = map.values.sum() / 2
    while( sumProbability < averageProbability ) {
        val entry = map.maxBy { it.value }
        map.remove(entry.key)
        firstMap[entry.key] = entry.value
        sumProbability+=entry.value

    }
    return getCodeMap(firstMap, "${code}0") + getCodeMap( map,"${code}1")

}

private fun getFirstPrefix(map: Map<String, String>, input: String): String {
    for (i in 1..input.length) {
        if (map.containsKey(input.substring(0, i))) return input.substring(0, i)
    }
    error("Message can not be decoded")
}


