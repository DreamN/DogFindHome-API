package com.inaranirattisai

/**
  * Created by inaraniratti on April, 2018
  */

sealed trait AnimalGender
case object MaleGender extends AnimalGender
case object FemaleGender extends AnimalGender

trait Animal {
  val name: String
  val age: Option[Int]
  val location: Location
  val gender: AnimalGender
  override def toString: String = s"I'm ${name}"
}

case class Dog(name: String, age: Option[Int]=None, location: Location, gender: AnimalGender) extends Animal {

}