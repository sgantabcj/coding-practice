package test;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AlterXMLFile {
    public static void main(String argv[]) {

        try {
            String filepath = "c:\\file.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node urlset = doc.getFirstChild();
            NodeList urlList = urlset.getChildNodes();

            for (int i = 1; i <= urlList.getLength(); i++) {
                Node url = urlList.item(i);
                if ("url".equals(url.getNodeName())) {
                    NodeList urlChildList = url.getChildNodes();
                    for (int j = 1; j <= urlChildList.getLength(); j++) {
                        Node image = urlChildList.item(i);
                        if ("image:image".equals(image.getNodeName())) {
                            NodeList imgChildList = image.getChildNodes();
                            for (int k = 1; k <= urlList.getLength(); k++) {
                                Node node = imgChildList.item(i);
                                if("image:loc".equals(node.getNodeName())){
                                    urlset.removeChild(url);
                                    i--;
                                }
                            }
                        }
                    }
                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
}
