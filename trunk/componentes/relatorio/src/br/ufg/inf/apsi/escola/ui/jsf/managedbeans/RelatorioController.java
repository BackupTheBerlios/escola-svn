package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import br.ufg.inf.apsi.escola.componentes.relatorios.servico.RelatorioService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class RelatorioController {

	private RelatorioService relatorioService = null;
	
	private LocalServiceFactory localServiceFactory = null;

	private Long idTurma;
	
	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public RelatorioController() {
		localServiceFactory = new LocalServiceFactory();
		relatorioService = localServiceFactory.obterRelatorioService();
	}

	public String geraRelatorioPDF() {
	    FacesContext fcontext = FacesContext.getCurrentInstance();
	    ExternalContext econtext = fcontext.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
		try {
			
			JasperPrint jasperPrint = relatorioService.gerarRelNotasFrequenciasTurma(idTurma);
			byte[] byteRelatorio = JasperExportManager.exportReportToPdf(jasperPrint);
			ServletOutputStream outstream = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setContentLength(byteRelatorio.length);
			response.setHeader("Content-disposition","inline;filename=\"RelatorioNFDeTurma.pdf\"");
			outstream.write(byteRelatorio);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
		}
		fcontext.responseComplete();
		return "OK";
	}

	public String geraRelatorioHTML() {
	    FacesContext fcontext = FacesContext.getCurrentInstance();
	    ExternalContext econtext = fcontext.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
	    HttpServletRequest request = (HttpServletRequest) econtext.getRequest();
		try {
			JasperPrint jasperPrint = relatorioService
					.gerarRelNotasFrequenciasTurma(idTurma);
			JRHtmlExporter exporter = new JRHtmlExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
			Map imagesMap = new HashMap();
			request.getSession().setAttribute("IMAGES_MAP", imagesMap);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
			exporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.FALSE);
	        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,request.getContextPath() + "/image?image=");
			exporter.exportReport();

		} catch (Exception e) {
		}
		fcontext.responseComplete();
	    return "OK";
	}

	public String geraRelatorioAvaliacaoDocenteTurmaPDF() {
	    FacesContext fcontext = FacesContext.getCurrentInstance();
	    ExternalContext econtext = fcontext.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
		try {
			
			JasperPrint jasperPrint = relatorioService.gerarRelAvaliacaoDocenteTurma(idTurma);
			byte[] byteRelatorio = JasperExportManager.exportReportToPdf(jasperPrint);
			ServletOutputStream outstream = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setContentLength(byteRelatorio.length);
			response.setHeader("Content-disposition","inline;filename=\"AvaliacaoDocente.pdf\"");
			outstream.write(byteRelatorio);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
		}
		fcontext.responseComplete();
		return "OK";
	}

	public String geraRelatorioAvaliacaoDocenteTurmaHTML() {
	    FacesContext fcontext = FacesContext.getCurrentInstance();
	    ExternalContext econtext = fcontext.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
	    HttpServletRequest request = (HttpServletRequest) econtext.getRequest();
		try {
			JasperPrint jasperPrint = relatorioService.gerarRelAvaliacaoDocenteTurma(idTurma);
			JRHtmlExporter exporter = new JRHtmlExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
			Map imagesMap = new HashMap();
			request.getSession().setAttribute("IMAGES_MAP", imagesMap);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
			exporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.FALSE);
	        request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,request.getContextPath() + "/image?image=");
			exporter.exportReport();

		} catch (Exception e) {
		}
		fcontext.responseComplete();
	    return "OK";
	}

}
