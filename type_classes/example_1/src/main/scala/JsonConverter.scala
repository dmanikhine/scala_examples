trait JsonConverter[A] {
    def convertToJson(value:A): JsonValue
}

object Conv {
val expressionJsonConverter= new JsonConverter[Expression]{
    def convertToJson(expr:Expression): JsonValue =
    expr match {
        case Number(value) => JsonNumber(value)
        case Plus(lhs,rhs) => JsonObject(
            Map("op"->JsonString("+"),
            "lhs"->convertToJson(lhs),
            "rhs"->convertToJson(rhs))) 
        case Minus(lhs,rhs) => JsonObject(
            Map("op"->JsonString("-"),
            "lhs"->convertToJson(lhs),
            "rhs"->convertToJson(rhs))) 
    }    
}
}