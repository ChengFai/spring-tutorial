package io.github.dunwu.springboot.core.validator;

import cn.hutool.core.util.StrUtil;
import io.github.dunwu.springboot.core.annotation.IsMobile;
import io.github.dunwu.tool.util.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-03-15
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {}

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StrUtil.isBlank(s)) {
            return false;
        } else {
            return ValidatorUtil.isMobile(s);
        }
    }

}
