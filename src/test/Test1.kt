package test

import java.util.*

fun main() {
    val list1 = arrayOf('a', 'd', 'c', 'b')
    val list2: List<Char> = list1.sortedBy { it }
    print(list1.contentToString())
    print(list2)
}


class Test1 {
}