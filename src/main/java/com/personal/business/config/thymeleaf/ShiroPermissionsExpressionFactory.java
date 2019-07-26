/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.config.thymeleaf;

import com.personal.business.constant.CommonConstant;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author sunpeikai
 * @version ShiroPermissionsExpressionFactory, v0.1 2019/7/26 14:40
 * @description
 */
public class ShiroPermissionsExpressionFactory implements IExpressionObjectFactory {

    public static final ShiroPermissionsUtils shiroPermissionsUtils = new ShiroPermissionsUtils();

    public static final Set<String> ALL_EXPRESSION_OBJECT_NAMES;

    static {
        final Set<String> allExpressionObjectNames = new LinkedHashSet<String>();
        allExpressionObjectNames.add(CommonConstant.THYMELEAF_TEMPLATE_UTILS);
        ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(allExpressionObjectNames);
    }

    public ShiroPermissionsExpressionFactory(){
        super();
    }

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return ALL_EXPRESSION_OBJECT_NAMES;
    }

    @Override
    public Object buildObject(IExpressionContext context, String expressionObjectName) {
        return CommonConstant.THYMELEAF_TEMPLATE_UTILS.equals(expressionObjectName) ? shiroPermissionsUtils : null;
    }

    @Override
    public boolean isCacheable(String expressionObjectName) {
        return CommonConstant.THYMELEAF_TEMPLATE_UTILS.equals(expressionObjectName);
    }
}
