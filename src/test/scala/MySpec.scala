
import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import akka.testkit.{ TestKit, ImplicitSender }
import org.specs2.mutable.SpecificationLike


class EchoActor extends Actor {
  def receive = {
    case msg => {
      println(s"echoing $msg")
      sender ! msg
    }
  }
}


class MySpec extends TestKit(ActorSystem()) with ImplicitSender with SpecificationLike {

  "An Echo actor" should {

    "send back messages unchanged" in {
      val echo = system.actorOf(Props[EchoActor],"echo-actor")
      val msg = "hello world"
      echo ! msg
      println("waiting for echo reply from echo actor")
      expectMsg(msg)
      success
    }

  }
}
