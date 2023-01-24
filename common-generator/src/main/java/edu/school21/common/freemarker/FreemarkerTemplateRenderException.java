package edu.school21.common.freemarker;

public class FreemarkerTemplateRenderException extends RuntimeException {
	public FreemarkerTemplateRenderException(String message) {
		super(message);
	}

	public FreemarkerTemplateRenderException(String message, Throwable cause) {
		super(message, cause);
	}

	public FreemarkerTemplateRenderException(Throwable cause) {
		super(cause);
	}

	public FreemarkerTemplateRenderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
