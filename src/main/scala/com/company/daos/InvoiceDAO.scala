package com.company.daos

import com.company.config.{DBConnection, DBProfile}
import com.company.models.Invoice

trait InvoiceDAOModule {
  self: DBConnection =>

  import profile.simple._

  val invoiceDAO: InvoiceDAO

  trait InvoiceDAO {

    def findAll: List[Invoice]

  }

  // I would never expose this in the module, it really should be a private member of the DAO Impl, however it is being
  // exposed to demo purposes to create/drop/seed a sample database.
  val invoices = TableQuery[Invoices]

  class InvoiceDAOImpl extends InvoiceDAO {

    def findAll: List[Invoice] = {
      database.withSession { implicit session =>
        invoices.list
      }
    }

  }

  class Invoices(tag: Tag) extends Table[Invoice](tag, "invoices") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def invoiceNumber = column[String]("invoice_number", O.NotNull)
    def total = column[BigDecimal]("total", O.NotNull)
    def * = (id, invoiceNumber, total) <> (Invoice.tupled, Invoice.unapply _)
  }

}
