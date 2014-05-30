package com.company.daos

import com.company.config.DBProfile
import com.company.models.Invoice

trait InvoiceDAOModule {
  self: DBProfile =>

  val invoiceDAO: InvoiceDAO

  trait InvoiceDAO {

    def findAll: List[Invoice]

  }

  class InvoiceDAOImpl extends InvoiceDAO {

    def findAll: List[Invoice] = {
      List(
        Invoice(Some(1), "INV1000", 5000.00),
        Invoice(Some(2), "INV2000", 6788.00),
        Invoice(Some(3), "INV3000", 54.45)
      )
    }

  }

}
