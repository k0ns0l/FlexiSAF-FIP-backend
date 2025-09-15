import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// define annotation -
@Retention(RetentionPolicy.RUNTIME)
@interface EnhancementRequest {
    int id();
    String synopsis();
    // default values
    String engineer() default "unassigned";
    String date() default "unknown";
}

// Example usage
@EnhancementRequest(
        id = 101,
        synopsis = "Add dark mode feature"
)
class FeatureClass {
    // ...
}

@EnhancementRequest(
        id = 102,
        synopsis = "optimize database queries",
        engineer = "k0ns0l",
        date = "2012-12-12"
)
class DatabaseFeature {
}

public class AnnotationDemo {
    public static void main(String[] args) {

        Class<FeatureClass> featureClass = FeatureClass.class;
        EnhancementRequest er1 = featureClass.getAnnotation(EnhancementRequest.class);
        System.out.println("FeatureClass -> Engineer: " + er1.engineer() + ", Date: " + er1.date());

        Class<DatabaseFeature> dbClass = DatabaseFeature.class;
        EnhancementRequest er2 = dbClass.getAnnotation(EnhancementRequest.class);
        System.out.println("DatabaseFeature -> Engineer: " + er2.engineer() + ", Date: " + er2.date());
    }
}
