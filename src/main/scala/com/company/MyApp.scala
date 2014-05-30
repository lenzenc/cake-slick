package com.company

import com.company.daos.DAORegistry
import com.company.config.ConfigDBConnection
import com.company.services.ServiceRegistry
import com.company.controllers.InvoiceController

object MyApp extends App {

  val app = new Application with ServiceRegistry with DAORegistry with ConfigDBConnection
  app.init
  app.getController(classOf[InvoiceController]).index.foreach {
    println
  }

}
