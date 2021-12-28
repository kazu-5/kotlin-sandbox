import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val mapper: ObjectMapper = jacksonObjectMapper()

/**
 * @param json 読み出し対象JSON
 * @param targetPropertyName 読み出し対象プロパティ名
 * @param dst デシリアライズ先クラス
 */
fun <T> readProperty(json: JsonNode, targetPropertyName: String, dst: Class<T>): T? {
    // プロパティの読み出し（getの場合無ければnullが返ってくる）
    val readedNode: JsonNode? = json.get(targetPropertyName)

    // プロパティを読み出せた場合、dstに指定した型へデシリアライズする
    return readedNode?.let { mapper.treeToValue(it, dst) }
}


fun main() {
    val rawJson = """
    {
        "value": "10",
        "hoge": null,
        "fuga": "aaa",
        "piyo": 0
    }
""".trimIndent()

    val json: JsonNode = mapper.readTree(rawJson)

// 文字列として読み出し
    val asString: String = readProperty(json, "value", String::class.java)!! // "10"
    println(asString)
// 整数として読み出し
    val asInt: Int = readProperty(json, "value", Int::class.java)!! // 10
    println(asInt)

// nullも読み出せる
    val asNull: Int? = readProperty(json, "hoge", Int::class.java)
    println(asNull)
}