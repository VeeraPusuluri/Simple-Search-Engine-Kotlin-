import java.util.Scanner

fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true){
        val key = readln()
        if (key!="stop" && !studentsMarks.contains(key)){
            studentsMarks[key] = readln().toInt()
        }else break
    }
    println(studentsMarks)
}