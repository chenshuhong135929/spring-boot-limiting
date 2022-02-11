package businessVerification;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Auther ChenShuHong
 * @Date 2022-02-09 13:59
 */
@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
//处理业务逻辑的类
@Constraint(validatedBy = UserValidation.UniqueUserValidator.class)
public @interface UniqueUser {

  String message() default "用户名、手机号码、邮箱不允许与现存用户重复";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
