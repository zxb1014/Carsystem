package com.yaohao.config;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

@Aspect
@Configuration // 定义一个切面
public class LogRecordAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

	// 定义切点Pointcut
	@Pointcut("execution(* com.sfa.web..*.*(..))")
	public void excudeService() {
	}

	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		Object[] args = pjp.getArgs();
		Map map=request.getParameterMap();
		String params = "";
		String str="";
		if (args.length > 0) {
			if ("POST".equals(method)) {
				Object object = args[0];
				Map map1 = getKeyAndValue(object);
				params = JSON.toJSONString(map1);
				str=JSON.toJSONString(map);
			} else if ("GET".equals(method)) {
				params = queryString;
			}
		}

		logger.info("请求开始===地址:" + url);
		logger.info("请求开始===类型:" + method);
		if(params.contains("0000000000111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999")){
			logger.info("请求开始===参数:" + str);
			
			
		}else{
			logger.info("请求开始===参数:" + params);
		}

		// // result的值就是被拦截方法的返回值
		Object result = pjp.proceed();
		Gson gson = new Gson();
		logger.info("请求结束===返回值:" + gson.toJson(result));
		return result;
	}

	public static Map<String, Object> getKeyAndValue(Object obj) {
		Map<String, Object> map = new HashMap<>();
		// 得到类对象
		Class userCla = (Class) obj.getClass();
		/* 得到类中的所有属性集合 */
		Field[] fs = userCla.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true); // 设置些属性是可以访问的
			Object val = new Object();
			try {
				val = f.get(obj);
				// 得到此属性的值
				map.put(f.getName(), val);// 设置键值
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return map;
	}
}