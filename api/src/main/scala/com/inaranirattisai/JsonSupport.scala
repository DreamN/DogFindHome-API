package com.inaranirattisai

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.inaranirattisai.services.LoggerServices
import spray.json.DefaultJsonProtocol.{jsonFormat2, jsonFormat4}
import spray.json.{DefaultJsonProtocol, JsString, JsValue, RootJsonFormat, deserializationError}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
/**
  * Created by inaraniratti on May, 2018
  */

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit object animalGenderFormat extends RootJsonFormat[AnimalGender] {
    def write(g: AnimalGender) = g match {
      case MaleGender => JsString("male")
      case FemaleGender => JsString("female")
    }

    def read(value: JsValue) = value match {
      case JsString("male") => MaleGender
      case JsString("female") => FemaleGender
      case _ => {
        LoggerServices.logger.error("animal's gender mismatch!")
        deserializationError("animal's gender mismatch!")
      }
    }
  }
  implicit val locationFormat = jsonFormat2(Location)
  implicit val DogFormat: RootJsonFormat[Dog] = jsonFormat4(Dog)

}
