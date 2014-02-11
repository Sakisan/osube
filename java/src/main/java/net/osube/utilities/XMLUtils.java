package net.osube.utilities;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;


/**
 * Created by: Antoine Snyers (antoine at atmire dot com)
 * Date: 11 Feb 2014
 */
public class XMLUtils {

    public static Document convertStreamToXML(String is) throws IOException {
        InputStream inputStream = IOUtils.toInputStream(is, "UTF-8");
        return convertStreamToXML(inputStream);

    }

    public static Document convertStreamToXML(InputStream is) {
        Document result = null;
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            result = builder.parse(is);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Applies a stylesheet to a given xml document.
     *
     * @param xmlDocument  the xml document to be transformed
     * @param xsltFilename the filename of the stylesheet
     * @return the transformed xml document
     */
    public static Document transformDocument(Document xmlDocument,
                                             String xsltFilename) throws TransformerException, ParserConfigurationException {
        return transformDocument(xmlDocument, new Hashtable<String, String>(), xsltFilename);
    }

    /**
     * Applies a stylesheet (that receives parameters) to a given xml document.
     *
     * @param xmlDocument  the xml document to be transformed
     * @param parameters   the hashtable with the parameters to be passed to the
     *                     stylesheet
     * @param xsltFilename the filename of the stylesheet
     * @return the transformed xml document
     */
  public static Document transformDocument(Document xmlDocument, Map<String, String> parameters, String xsltFilename) throws TransformerException, ParserConfigurationException {

        File xslFile = new File(xsltFilename);
        if (xslFile.exists()) {

            // Generate a Transformer.
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer(new StreamSource(xsltFilename));

            if (transformer != null) {


                // set transformation parameters
                if (parameters != null) {
                    for (Map.Entry<String, String> param : parameters.entrySet()) {
                        transformer.setParameter(param.getKey(), param.getValue());
                    }
                }

                // Create an empty DOMResult object for the output.
                DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
                dFactory.setNamespaceAware(true);
                DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
                Document dstDocument = dBuilder.newDocument();

                DOMResult domResult = new DOMResult(dstDocument);

                // Perform the transformation.
                transformer.transform(new DOMSource(xmlDocument), domResult);
                // Now you can get the output Node from the DOMResult.
                return dstDocument;
            }
        }
        return null;
    }
}
