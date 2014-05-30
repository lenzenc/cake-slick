package com.company.config

import com.typesafe.config.ConfigFactory
import scala.slick.driver.{H2Driver, JdbcProfile}

trait ConfigDBConnection extends DBConnection {
  val configProps = ConfigFactory.load()
  override lazy val profile: JdbcProfile = H2Driver
  override lazy val config: DBConfig = DBConfig.fromConfig(configProps, "app.slick.database")

}
