package io.github.dunwu.spring.core.validation;

import org.springframework.expression.ParseException;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;

@ValidRule
public class DateValidatorRule extends AbstractValidatorRule {

    @Override
    public boolean support(Annotation annotation) {
        return annotation instanceof DateString;
    }

    @Override
    public void validProperty(Annotation annotation, Object property, PostHandler postHandler) {
        DateString ds = (DateString) annotation;
        if (parse(ds.pattern(), (String) property) == null) {
            postHandler.postHanle(ds.errorCode(), ds.message());
        }
    }

    private Date parse(String pattern, String property) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(property);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
