package com.company

import com.company.services.ServiceRegistry
import com.company.daos.DAORegistry
import com.company.config.DBConnection
import com.company.controllers.{InvoiceController, InvoiceControllerModule}
import scala.reflect.{classTag, ClassTag}
import scala.language.existentials
import scala.slick.jdbc.meta.MTable
import com.company.models.Invoice
import com.company.models.Invoice

class Application
  extends InvoiceControllerModule
{
  self: ServiceRegistry with DAORegistry with DBConnection =>

  import profile.simple._

  implicit lazy val session = database.createSession()

  def getController[A](controllerClass: Class[A]): A = {
    instances(controllerClass).asInstanceOf[A]
  }

  def init = {

      invoices.ddl.create
      invoices ++= Seq(
        Invoice(Some(1), "INV1000", 1000.00),
        Invoice(Some(2), "INV2000", 16700.00),
        Invoice(Some(3), "INV3000", 156.43)
      )

  }

  private val instances: Map[Class[_ <: Any], Any] = {
    def controller[A: ClassTag](instance: A) = classTag[A].runtimeClass -> instance

    Map(
      controller[InvoiceController](new InvoiceControllerImpl)
    )
  }

}
