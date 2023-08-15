import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
public class LoggingControl implements LoggingControlMBean {

    private LoggingAspect loggingAspect;

    public LoggingControl(LoggingAspect loggingAspect) {
        this.loggingAspect = loggingAspect;
    }

    public void enableLogging() {
        loggingAspect.setLoggingEnabled(true);
    }

    public void disableLogging() {
        loggingAspect.setLoggingEnabled(false);
    }

    public boolean isLoggingEnabled() {
        return loggingAspect.loggingEnabled;
    }

    public static void registerMBean() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("YourDomain:type=LoggingControl");
        LoggingAspect aspect = new LoggingAspect();
        LoggingControl control = new LoggingControl(aspect);
        mbs.registerMBean(control, name);
    }
}

