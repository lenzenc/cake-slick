package com.company.controllers

import com.company.services.InvoiceServiceModule
import com.company.models.Invoice

trait InvoiceController {

  def index: List[Invoice]

}

trait InvoiceControllerModule {
  self: InvoiceServiceModule =>

  class InvoiceControllerImpl extends InvoiceController {

    def index: List[Invoice] = {
      invoiceService.list
    }

  }

}
