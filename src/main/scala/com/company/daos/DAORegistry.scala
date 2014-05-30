package com.company.daos

import com.company.config.DBConnection

trait DAORegistry extends InvoiceDAOModule {
  self: DBConnection =>

  val invoiceDAO = new InvoiceDAOImpl

}