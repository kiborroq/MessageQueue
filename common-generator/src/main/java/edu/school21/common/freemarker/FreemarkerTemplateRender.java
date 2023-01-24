package edu.school21.common.freemarker;

import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Render freemarker template and convert it to PDF
 */
public class FreemarkerTemplateRender {

	private final Configuration configuration;
	private final ITextRenderer renderer;

	public FreemarkerTemplateRender(String templatesFolder) {
		configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
		configuration.setLogTemplateExceptions(false);
		configuration.setOutputFormat(HTMLOutputFormat.INSTANCE);
		configuration.setClassLoaderForTemplateLoading(getClass().getClassLoader(), templatesFolder);

		renderer = new ITextRenderer();
	}

	public void renderPdf(String templateName, Map<String, Object> data, OutputStream os) throws FreemarkerTemplateRenderException {
		try (StringWriter writer = new StringWriter()) {
			Template template = configuration.getTemplate(templateName);
			template.process(data, writer);

			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8)));
			renderer.setDocument(doc, null);
			renderer.layout();
			renderer.createPDF(os);
		} catch (Exception e) {
			throw new FreemarkerTemplateRenderException(String.format("Error during freemarker template '%s' render", templateName), e);
		}
	}

}
