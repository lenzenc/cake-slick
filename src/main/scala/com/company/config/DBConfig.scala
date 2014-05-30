package com.company.config

import com.typesafe.config.Config

trait DBConfig {

  def url: String
  def driver: String
  def username: String
  def password: String

}

object DBConfig {

  def fromConfig(config: Config, root: String): DBConfig = new DBConfig {

    override def url: String = config.getString(s"$root.url")
    override def driver: String = config.getString(s"$root.driver")
    override def username: String = config.getString(s"$root.username")
    override def password: String = config.getString(s"$root.password")

  }

  def apply(dbUrl: String, dbDriver: String, dbUsername: String, dbPassword: String) = new DBConfig {

    override def url: String = dbUrl
    override def driver: String = dbDriver
    override def username: String = dbUsername
    override def password: String = dbPassword

  }

}