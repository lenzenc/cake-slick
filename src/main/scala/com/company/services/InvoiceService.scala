package com.company.services

import com.company.daos.InvoiceDAOModule
import com.company.models.Invoice

trait InvoiceServiceModule {
  self: InvoiceDAOModule =>

  val invoiceService: InvoiceService

  trait InvoiceService {

    def list: List[Invoice]

  }

  class InvoiceServiceImpl extends InvoiceService {

    def list: List[Invoice] = {
      invoiceDAO.findAll
    }

  }

}
