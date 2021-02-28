import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


public class ServletApplication {

  public static void main(String[] args) throws Exception {

    Server server = new Server(8081);
    ServletHandler servletHandler = new ServletHandler();

    servletHandler.addServletWithMapping(Counter.class, "/counter");
    servletHandler.addServletWithMapping(CounterClear.class, "/counter/clear");
    server.setHandler(servletHandler);

    server.start();
    server.join();
    // run, Jetty, run!
  }
}
