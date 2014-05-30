## Cake - Slick Example Application
This is a sample application using slick and the cake pattern for dependency injection.  Being new to scala I've been
experimenting quite a bit with what is the best approach for dependency injection and have came to the conclusion that
the cake pattern is likely the better direction, in my opinion, since it is native to the language and doesn't feel like
using Java in the cases of Spring or Guice.

Deciding the cake pattern was the approach to take I found that out of the large number of cake sample code / applications
that there were not a lot of real world type examples that showed cake when considering a N-layered architecture, like
having a controller, service, DAO layer.  So I figured I would create a very simple application that removed the overhead
of using cake in conjunction with other application frameworks like Spray or Play.

This pattern can be used in any application framework that you might want and or using.  For example if I wanted to use
this pattern in Play I would like rename the Application class to Controllers and override Play's "getControllerInstance"
method;

    object Global extends play.api.GlobalSettings {

        private val injector = SomeDependencyInjectionFramework

        override def getControllerInstance[A](controllerClass: Class[A]): A = {
            injector.getInstance(controllerClass)
        }
    }

Note Subcut & Scaldi are also nice options, very similar in usage but I just didn't feel like they added much value over
the cake pattern.

### Running this Application
    sbt
    > run
    
This sample application also has the "sbt-revolver" plugin so if you want sbt to automatically re-compile you can use the
following command;

    sbt
    > ~ re-start
    
__Enjoy!! ....comments and feedback are more than welcome.__