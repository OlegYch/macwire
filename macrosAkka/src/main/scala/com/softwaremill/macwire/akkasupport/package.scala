package com.softwaremill.macwire

import akka.actor.{Actor, ActorRef, IndirectActorProducer, Props}

import scala.language.experimental.macros

package object akkasupport {
  def wireProps[T <: Actor]: Props = macro MacwireAkkaMacros.wireProps_Impl[T]
  def wireAnonymousActor[T <: Actor]: ActorRef = macro MacwireAkkaMacros.wireAnonymousActor_Impl[T]
  def wireActor[T <: Actor](name: String): ActorRef = macro MacwireAkkaMacros.wireActor_Impl[T]
  def wirePropsWith[T]: Props = macro MacwireAkkaMacros.wirePropsWith_Impl[T]
  def wireAnonymousActorWith[T]: ActorRef = macro MacwireAkkaMacros.wireAnonymousActorWith_Impl[T]
  def wireActorWith[T](name: String): ActorRef = macro MacwireAkkaMacros.wireActorWith_Impl[T]

  def wireAnonymousActorWith[T](factory: () => T): ActorRef = macro MacwireAkkaMacros.wireAnonymousActorWithFactory_Impl[T]
  def wireAnonymousActorWith[A, T](factory: (A) => T): ActorRef = macro MacwireAkkaMacros.wireAnonymousActorWithFactory_Impl[T]
  def wireAnonymousActorWith[A, B, T](factory: (A, B) => T): ActorRef = macro MacwireAkkaMacros.wireAnonymousActorWithFactory_Impl[T]
  def wireAnonymousActorWith[A, B, C, T](factory: (A, B, C) => T): ActorRef = macro MacwireAkkaMacros.wireAnonymousActorWithFactory_Impl[T]
  //FIXME: more function types
}

