package com.sallee.bangbangla.exception;


import com.sallee.bangbangla.pojo.ServerResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice      //调用controller时自动调用方法
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler //发生异常自动执行
	public ServerResult exceptionHandle(Throwable e) {
		//得到异常信息
		String message = e.getMessage();
		//保存到数据库，在网页中显示出来，判断异常等级
		e.printStackTrace();  //暂时打到控制台代替
		//返回错误信息给前端
		ServerResult serverResult = new ServerResult(500,"服务器出错，请在控制台查看错误详细信息",message);
		return serverResult;
	}
}
