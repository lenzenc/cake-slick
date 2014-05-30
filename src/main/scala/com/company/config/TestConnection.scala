package com.company.config

import scala.slick.driver.{MySQLDriver, JdbcProfile}

trait TestConnection extends DBConnection {

  override lazy val profile: JdbcProfile = MySQLDriver
  override lazy val config: DBConfig = DBConfig.apply(
    "jdbc:mysql://localhost:3306/payit?characterEncoding=UTF-8",
    "com.mysql.jdbc.Driver",
    "root",
    "root"
  )

}
