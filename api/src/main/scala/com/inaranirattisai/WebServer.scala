package com.inaranirattisai

/**
  * Created by inaraniratti on April, 2018
  */

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.inaranirattisai.services.LoggerServices
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.io.StdIn

object WebServer {
  def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    val conf = ConfigFactory.load()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val interface = conf.getString("webserver.interface")
    val port = conf.getInt("webserver.port")
    val bindingFuture = Http().bindAndHandle(Routes.route, interface, port)
    LoggerServices.logger.info(s"Server online at http://$interface:$port")
    LoggerServices.logger.info(s"Ctrl + D to terminate batch job")
  }
}