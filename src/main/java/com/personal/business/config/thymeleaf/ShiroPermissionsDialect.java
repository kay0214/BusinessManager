/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.config.thymeleaf;

import com.personal.business.constant.CommonConstant;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * @author sunpeikai
 * @version ShiroPermissionsDialect, v0.1 2019/7/26 14:39
 * @description
 */
public class ShiroPermissionsDialect extends AbstractDialect implements IExpressionObjectDialect {
    public ShiroPermissionsDialect() {
        super(CommonConstant.THYMELEAF_TEMPLATE_UTILS);
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new ShiroPermissionsExpressionFactory();
    }
}
