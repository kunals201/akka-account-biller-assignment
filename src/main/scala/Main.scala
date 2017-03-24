import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration.DurationDouble
object Main extends App{
  val system = ActorSystem("RouterSystem")
  val accountRequest = system.actorOf(UserAccountGenerator.prop)
  val salaryDepositRequest = system.actorOf(SalaryDepositService.prop)

//  val list=List(
//  UserAccount("a","a","a",10000),UserAccount("a","a","b",10000),UserAccount("a","a","c",10000),
//  UserAccount("a","a","a",10000)
//)
//  val listOfbills=List(
//    BillerInfo(phone,"a",0,"",10,10,10,10),BillerInfo(internet,"a",0,"",10,10,10,10)
//    ,BillerInfo(car,"a",0,"",10,20,10,20)
//  )
implicit val timeout=Timeout(1000 seconds)

val res=for(i<- 1001 to 1010){

val f=  accountRequest ? (UserAccount("a","a","a"+i,1000),i)
Await.result(f,timeout.duration)
  println(f)
}

 //  Thread.sleep(5000)

  for(i<- 1001 to 1010) {
  salaryDepositRequest ? List(("a"+i,i,2000.50))
}
  Thread.sleep(2000)
  println(UserAccountService.listOfUserAccount)

//  implicit val timeout=Timeout(1000 seconds)
//val res=list.map(x=> accountRequest ? x)
//val resBill=listOfbills.map(x=>accountRequest ? x)
// res.foreach(println(_))
//println(UserAccountService.listOfUserAccount)
//resBill.foreach(println(_))
//  println(UserAccountService.listOfUserBills)

//  val resOfDeposit=salaryDeposit.map(x =>salaryDepositRequest ! List(x))
//  resOfDeposit.foreach(println(_))


//Thread.sleep(2000)
//println(UserAccountService.listOfUserAccount)

}

