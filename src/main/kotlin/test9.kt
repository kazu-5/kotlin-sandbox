fun StableMariage(male: Array<IntArray>, female: Array<IntArray>): IntArray {
    val n = male.size
    val freeMen = ArrayDeque<Int>()
    val partner = IntArray(n) { -1 }
    val nextProposal = IntArray(n) { 0 }

    for (i in 0 until n) {
        freeMen.add(i)
    }

    val femalePartner = IntArray(n) { -1 }
    val femaleRank = Array(n) { IntArray(n) { -1 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (female[i][j] != -1) {
                femaleRank[i][female[i][j]] = j
            }
        }
    }

    while (freeMen.isNotEmpty()) {
        val man = freeMen.removeFirst()

        while (nextProposal[man] < n) {
            val woman = male[man][nextProposal[man]++]

            if (woman == -1) continue
            if (woman < 0 || woman >= n) continue

            if (femalePartner[woman] == -1) {
                femalePartner[woman] = man
                partner[man] = woman
                break
            } else {
                val currentMan = femalePartner[woman]
                if (femaleRank[woman][man] < femaleRank[woman][currentMan]) {
                    freeMen.add(currentMan)
                    femalePartner[woman] = man
                    partner[man] = woman
                    freeMen.add(currentMan)
                    break
                }
            }
        }
        if(partner[man] == -1 && nextProposal[man] < n) {
            freeMen.add(man)
        }

    }
//    return partner

    val result = IntArray(n) { -1 }
    for (i in 0 until n) {
        if (femalePartner[i] != -1) {
            result[i] = femalePartner[i]
        }
    }

    return result
}


fun main() {
    
    var test = StableMariage(arrayOf(intArrayOf(0,1), intArrayOf(0,1)), arrayOf(intArrayOf(0,1), intArrayOf(0,1)))
    println(test.size)
    println(test.joinToString(" "))
}