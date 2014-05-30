package com.company.services

import com.company.daos.{DAORegistry, InvoiceDAOModule}
import com.company.config.{DBProfile, DBConnection}

trait ServiceRegistry extends InvoiceServiceModule {
  self: DAORegistry with DBConnection =>

  val invoiceService = new InvoiceServiceImpl

}
