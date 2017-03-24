import akka.actor.{Actor, Props}
import akka.dispatch.RequiresMessageQueue
import akka.dispatch.BoundedMessageQueueSemantics

class UserAccountGenerator extends Actor  with RequiresMessageQueue[BoundedMessageQueueSemantics]{
//var accountNumberImplicitly:BigInt=0
  override def receive = {
    case (obj:UserAccount,accountNumberImplicitly:Int)=>
     if(!checker(obj)){
      // accountNumberImplicitly+=1
       val userObject=obj.copy(obj.accountHolderName,obj.address,obj.userName,obj.initialAmount,accountNumberImplicitly)
      // println(userObject)
       UserAccountService.listOfUserAccount +=(obj.userName->userObject)
       //println(UserAccountService.listOfUserAccount)
       sender ! ("user added successfully", userObject)
     }
      else{
      sender ! "Already Exist"
     }

case obj:BillerInfo=> UserAccountService.listOfUserBills+=(obj.accountNumber->obj)
  sender ! "bill added"
  }

def checker(obj:UserAccount):Boolean={
    if(UserAccountService.listOfUserAccount.contains(obj.userName))
  true
  else
    false
  }
}
object UserAccountGenerator {

  def prop: Props = Props[UserAccountGenerator]

}
