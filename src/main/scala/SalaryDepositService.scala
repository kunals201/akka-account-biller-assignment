import akka.actor.{Actor, ActorRef, Props}

class SalaryDepositService extends Actor{
  override def receive ={
  case salaryList: List[(String, Int, Double)] => {

    for (ls <- salaryList) {

    val res = UserAccountService.listOfUserAccount.values.toList
    for (user <- res) {
    if (user.userName == ls._1 && user.accountNumber == ls._2) {
    val newUserAccount = user.copy(initialAmount = user.initialAmount+ls._3)
    //println(newUserAccount)
   // UserAccountService.listOfUserAccount -= user.userName
    UserAccountService.listOfUserAccount += (user.userName -> newUserAccount)
    //println(UserAccountService.listOfUserAccount)
    println("SalaryDeposited")
  }
  }
  }
  }
  case _=> println("Incorrect Input")
}
}
object SalaryDepositService {

  def prop: Props = Props[SalaryDepositService]

}

