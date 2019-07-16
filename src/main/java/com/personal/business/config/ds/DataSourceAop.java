package com.personal.business.config.ds;

import com.personal.business.constant.CommonConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop implements Ordered {

    @Pointcut("execution(* com.personal..*Service.*(..))")
    public void serviceAspect() {
    }

    @Before("serviceAspect()")
    public void switchDataSource(JoinPoint point) {
        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
        if (isQueryMethod) {
            DynamicDataSourceContextHolder.useSlaveDataSource();
        }
    }

    @After("serviceAspect())")
    public void restoreDataSource(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }

    @AfterThrowing("serviceAspect())")
    public void restoreDataSourceException(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }

    private Boolean isQueryMethod(String methodName) {
        for (String prefix : CommonConstant.DATASOURCE_QUERY_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

	@Override
	public int getOrder() {
		return CommonConstant.DATASOURCE_AOP_DS;
	}
    
}
