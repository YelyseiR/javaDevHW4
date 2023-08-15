import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    public boolean loggingEnabled = false;
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    @Before("execution(* StringTransformer.transform(String)) && args(input)")
    public void logTransformation(JoinPoint joinPoint, String input) {
        if (loggingEnabled) {
            System.out.println("Original string: " + input);
            System.out.println("Transforming string...");
        }
    }
}
