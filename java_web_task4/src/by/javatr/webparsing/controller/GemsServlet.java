package by.javatr.webparsing.controller;
import by.javatr.webparsing.dao.FileHandler;
import by.javatr.webparsing.dao.GemsDAO;
import by.javatr.webparsing.dao.ParserFactory;
import by.javatr.webparsing.service.entity.Gem;
import by.javatr.webparsing.service.entity.NaturalGem;
import by.javatr.webparsing.service.entity.SyntheticGem;
import by.javatr.webparsing.service.util.Selection;
import by.javatr.webparsing.view.Dialog;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.List;

@WebServlet("/parsing")
@MultipartConfig
public class GemsServlet extends HttpServlet {
    private static final String GEMS_JSP = "/WEB-INF/gems.jsp";
    private static final String PARSER_TYPE_ATTRIBUTE = "parserType";
    private static final String XML_FILE = "fileXML";
    private static final String GEMS_ATTRIBUTE_NATURAL = "gemsNatural";
    private static final String GEMS_ATTRIBUTE_SYNTHETIC = "gemsSynthetic";
    private static String xmlFileName="";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String parserType = req.getParameter(PARSER_TYPE_ATTRIBUTE);
        try {
            xmlFileName=req.getPart(XML_FILE).getSubmittedFileName();
            InputStream is = req.getPart(XML_FILE).getInputStream();

            File targetFile = new File(xmlFileName);

            java.nio.file.Files.copy(is, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            //new FileHandler().updateFile(XML_FILE, req);

            Dialog dialog = new Dialog(xmlFileName);

            GemsDAO gems = dialog.getGemsDAOfromXML(ParserFactory.TypeParser.valueOf(parserType));

            List <NaturalGem> naturalGemsList = Selection.selectNaturalGem(gems);
            List <SyntheticGem> syntheticGemList = Selection.selectSyntheticGem(gems);

            SyntheticGem gm=syntheticGemList.get(0);

            gm.getManufacturingMethodOrProcesingMethod();

            req.setAttribute(GEMS_ATTRIBUTE_NATURAL, naturalGemsList);
            req.setAttribute(GEMS_ATTRIBUTE_SYNTHETIC, syntheticGemList);
            req.setAttribute(PARSER_TYPE_ATTRIBUTE, parserType);
            getServletContext().getRequestDispatcher(GEMS_JSP).forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFile(String destination, HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart(XML_FILE);
        File file = new File(destination);
        try(InputStream filecontent = filePart.getInputStream();
            OutputStream out = new FileOutputStream(file)) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
    }
}

