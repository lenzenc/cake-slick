package com.company.config

import scala.slick.driver.JdbcProfile

trait DBProfile {

  val profile: JdbcProfile

}
