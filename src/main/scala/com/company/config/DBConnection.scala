package com.company.config

trait DBConnection extends DBProfile with DBConfiguration {

  import profile.simple._

  def database: Database = {
    Database.forURL(url = config.url, user = config.username, password = config.password, driver = config.driver)
  }

}
