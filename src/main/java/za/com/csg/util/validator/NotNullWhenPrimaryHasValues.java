package za.com.csg.util.validator;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNullWhenPrimaryHasValues {
	
	NotNullWhenPrimaryHasValue[] value();

}
