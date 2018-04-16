package com.inaranirattisai

/**
  * Created by inaraniratti on April, 2018
  */

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.io.StdIn

object WebServer {
  def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    val conf = ConfigFactory.load()
    val logger = Logger(LoggerFactory.getLogger("api"))
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val route =
      path("hello") {
        get {
          val milo: Dog = new Dog("Milo", Some(4), new Location(1.34, 20.328), FemaleGender)
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>Say hello to ${milo}</h1>"))
        }
      }
    val interface = conf.getString("webserver.interface")
    val port = conf.getInt("webserver.port")
    val bindingFuture = Http().bindAndHandle(route, interface, port)
    logger.info(s"Server online at http://$interface:$port")
    logger.info(s"Ctrl + D to terminate batch job")
  }
}