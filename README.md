specs2-akka-testkit-demo
========================

# Intro
This is a dead simple demo to test Actors with [specs2](http://etorreborre.github.io/specs2/) with Akka [TestKit](http://doc.akka.io/docs/akka/snapshot/scala/testing.html).  The code is modified from the demo code at http://doc.akka.io/docs/akka/snapshot/scala/testing.html#Asynchronous_Integration_Testing_with_TestKit, which is for [scalatest](http://www.scalatest.org/).

The end result is very simple but I had to take the code apart and put it back together again to understand it.

# Running
```bash
> sbt test
```

## Key take away
Everything is in the docs, but the part that I didn't notice the first few times I read them was that `expectMsg` and other assertions don't work for all actors, they only monitor `testActor`, a special ActorRef provided by TestKit.  If you are testing a response from an actor you have to use the non-sugared tell syntax so that testActor gets the response `acotor ! (msg, testActor)` or mix in the trait `with ImplicitSender` so that `testActor` shows up as the sender to all messages send in the test.
