package com.company

import com.company.services.ServiceRegistry
import com.company.daos.DAORegistry
import com.company.config.DBConnection
import com.company.controllers.{InvoiceController, InvoiceControllerModule}
import scala.reflect.{classTag, ClassTag}
import scala.language.existentials

class Application
  extends InvoiceControllerModule
{
  self: ServiceRegistry with DAORegistry with DBConnection =>

  def getController[A](controllerClass: Class[A]): A = {
    instances(controllerClass).asInstanceOf[A]
  }

  def init = {

  }

  private val instances: Map[Class[_ <: Any], Any] = {
    def controller[A: ClassTag](instance: A) = classTag[A].runtimeClass -> instance

    Map(
      controller[InvoiceController](new InvoiceControllerImpl)
    )
  }

}
