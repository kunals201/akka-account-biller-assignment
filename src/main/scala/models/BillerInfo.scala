sealed trait category extends Product with Serializable
case object phone extends category
case object electricity extends category
case object internet extends category
case object food extends category
case object car extends category



case class BillerInfo(billerCategory:category,billerName:String,accountNumber:BigInt,transactionDate:String,amount:Long,totalIterations:Int,executedIterations:Int,paidAmount:BigInt)
