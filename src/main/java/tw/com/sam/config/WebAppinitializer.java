package tw.com.sam.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//相當於web.xml的Java程式組態設定
public class WebAppinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//	用來註冊相當於Beans.config.xml的java程式組態設定
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
//		return null;
	}
//	用來註冊相當於Mcv-servlet.xml
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};
//		return null;
	}
//	相當於DispatcherServlet接受Http請求網址路徑
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"} ;
//		return null;
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef = new CharacterEncodingFilter("UTF-8",true); //記得要加
		cef.setEncoding("UTF-8");
		return new Filter[] {cef};
	}
}
