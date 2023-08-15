import org.junit.jupiter.api.Test;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggingControlTest {

    @Test
    public void testLoggingControl() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("YourDomain:type=LoggingControl");

        LoggingAspect aspect = new LoggingAspect();
        LoggingControl control = new LoggingControl(aspect);
        mbs.registerMBean(control, name);

        assertFalse(aspect.isLoggingEnabled());

        LoggingControlMBean proxy = JMX.newMBeanProxy(mbs, name, LoggingControlMBean.class);
        proxy.enableLogging();
        assertTrue(aspect.isLoggingEnabled());

        proxy.disableLogging();
        assertFalse(aspect.isLoggingEnabled());
    }
}

