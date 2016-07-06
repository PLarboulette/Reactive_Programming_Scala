package models.characters

import models.stuff.Weapon
import rx.lang.scala.Observable
import scala.collection.mutable

/**
  * Created by Pierre on 06/07/2016.
  */

case class Hero (name: String, pv : Integer, pm : Integer, weapons : mutable.Set[Weapon]) {}

object Hero {

  def addWeapon (oldHero : Hero, weapon : Weapon) : Hero = {
    val result : mutable.Set[Weapon] = mutable.Set()
    result.++=(oldHero.weapons)
    Observable.just(weapon).subscribe {
      weapon : Weapon  => result.add(weapon)
        error : Throwable => println(error.getMessage)
          ()  => println("FINISHED")
    }
    val hero = Hero(oldHero.name, oldHero.pv, oldHero.pm, result)
    hero
  }


}
