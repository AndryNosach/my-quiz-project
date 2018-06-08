package listeners;

import dao.connector.DBConnector;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    Logger logger = Logger.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();
        String dburl="jdbc:mysql://52.30.113.60/heroku_c84694dc9cc3e36?reconnect=true";
        String dbusername= "bd45281a0339ee";
        String dbpassword="6e0017fc";

        logger.info("Trying to connect "+dburl);
        DBConnector.createConnection(dburl, dbusername, dbpassword);
        logger.info("Connection Establised.........");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnector.closeConnection();
    }

}
