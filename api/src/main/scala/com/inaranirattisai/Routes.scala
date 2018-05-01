package com.inaranirattisai

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

/**
  * Created by inaraniratti on May, 2018
  */


object Routes extends JsonSupport {

  val route:Route =
    path("hello") {
      get {
        val milo: Dog = new Dog("Milo", Some(4), new Location(1.34, 20.328), FemaleGender)
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>Say hello to ${milo}</h1>"))
      } ~
      post {
        entity(as[Dog]) { dog =>
          complete(s"${dog}")
        }
      }
    }

}
