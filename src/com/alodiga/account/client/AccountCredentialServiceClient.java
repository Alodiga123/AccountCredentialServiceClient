package com.alodiga.account.client;

import com.alodiga.account.credential.response.StatusAccountResponse;
import com.alodiga.account.utils.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author ltoro
 */
public class AccountCredentialServiceClient {

    private static final int CONNECTION_TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {
        AccountCredentialServiceClient accountCredentialServiceClient = new AccountCredentialServiceClient();
        StatusAccountResponse accountResponse = accountCredentialServiceClient.statusAccount("PilotoWS", "America/Caracas", "543932601");
        System.out.println(accountResponse.getDescripcionEstado());
    }

    public StatusAccountResponse statusAccount(String user, String timeZone, String account) throws MalformedURLException, IOException, Exception {
        String formattedSOAPResponse = "";

        try {

            ignoreSSL();
            String responseString = "";
            String outputString = "";
            String wsEndPoint = Constants.URL_PROD;
            URL url = new URL(wsEndPoint);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            httpConn.setConnectTimeout(CONNECTION_TIMEOUT);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            StringBuilder builder = new StringBuilder("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:syn=\"http://ws.apache.org/ns/synapse\">");
            builder.append("<soapenv:Header/>");
            builder.append("<soapenv:Body>");
            builder.append("<syn:ConsultarRequest>");
            builder.append("<Autenticacion>");
            builder.append("<Usuario>" + Constants.USER_PROD + "</Usuario>");
            builder.append("<Password>" + Constants.PASSWORD_PROD + "</Password>");
            builder.append("</Autenticacion>");
            builder.append("<Originador>");
            builder.append("<Solicitante>" + Constants.USER_PROD + "</Solicitante>");
            builder.append("<ZonaHoraria>" + timeZone + "</ZonaHoraria>");
            builder.append("</Originador>");
            builder.append("<Cuenta>" + account + "</Cuenta>");
            builder.append("</syn:ConsultarRequest>");
            builder.append("</soapenv:Body>");
            builder.append("</soapenv:Envelope>");
            byte[] buffer = new byte[builder.toString().length()];
            buffer = builder.toString().getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            String SOAPAction = "Consultar";
            httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
            // Write the content of the request to the outputstream of the HTTP
            // Connection.
            out.write(b);
            out.close();
            // Ready with sending the request.
            // Read the response.
            InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
            BufferedReader in = new BufferedReader(isr);
            // Write the SOAP message response to a String.

            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            formattedSOAPResponse = formatXML(outputString);
            System.out.println(outputString);
            StatusAccountResponse accountResponse = new StatusAccountResponse();
            accountResponse.setCodigo(getTagValue("Codigo", getTagValue("Response", formattedSOAPResponse)));
            accountResponse.setDescripcion(getTagValue("Descripcion", formattedSOAPResponse));
            accountResponse.setNumero(getTagValue("Numero", formattedSOAPResponse));
            accountResponse.setCodigoEstado(getTagValue("Codigo", getTagValue("Estado", formattedSOAPResponse)));
            accountResponse.setDescripcionEstado(getTagValue("Descripcion", formattedSOAPResponse));
            accountResponse.setCodigoEntidad(getTagValue("Codigo", getTagValue("Entidad", formattedSOAPResponse)));
            accountResponse.setDescripcionEntidad(getTagValue("Descripcion", formattedSOAPResponse));
            accountResponse.setSucursal(getTagValue("Sucursal", formattedSOAPResponse));
            accountResponse.setCodigoProducto(getTagValue("Codigo", getTagValue("Producto", formattedSOAPResponse)));
            accountResponse.setDescripcionProducto(getTagValue("Descripcion", formattedSOAPResponse));
            accountResponse.setCodigoPais(getTagValue("Codigo", getTagValue("Pais", formattedSOAPResponse)));
            accountResponse.setDescripcionPais(getTagValue("Descripcion", formattedSOAPResponse));
            accountResponse.setCodigoMoneda(getTagValue("Codigo", getTagValue("Moneda", formattedSOAPResponse)));
            accountResponse.setDescripcionMoneda(getTagValue("Descripcion", formattedSOAPResponse));
            accountResponse.setVIP(getTagValue("VIP", formattedSOAPResponse));
            accountResponse.setHCC(getTagValue("HCC", formattedSOAPResponse));
            accountResponse.setULC(getTagValue("ULC", formattedSOAPResponse));
            accountResponse.setMCC(getTagValue("MCC", formattedSOAPResponse));
            accountResponse.setMomentoRenewal(getTagValue("MomentoRenewal", formattedSOAPResponse));
            accountResponse.setMomentoUltimaActualizacion(getTagValue("MomentoUltimaActualizacion", formattedSOAPResponse));
            accountResponse.setMomentoUltimaOperacionAprobada(getTagValue("MomentoUltimaOperacionAprobada", formattedSOAPResponse));
            accountResponse.setMomentoUltimaOperacionDenegada(getTagValue("MomentoUltimaOperacionDenegada", formattedSOAPResponse));
            accountResponse.setMomentoUltimoBloqueo(getTagValue("MomentoUltimoBloqueo", formattedSOAPResponse));
            accountResponse.setMomentoUltimoDesbloqueo(getTagValue("MomentoUltimoDesbloqueo", formattedSOAPResponse));
            accountResponse.setComprasDisponibles(getTagValue("Compras", formattedSOAPResponse));
            accountResponse.setCuotasDisponibles(getTagValue("Cuotas", formattedSOAPResponse));
            accountResponse.setAdelantosDisponibles(getTagValue("Adelantos", formattedSOAPResponse));
            accountResponse.setPrestamosDisponibles(getTagValue("Prestamos", formattedSOAPResponse));
            accountResponse.setComprasLimites(getTagValue("Compras", formattedSOAPResponse));
            accountResponse.setCuotasLimites(getTagValue("Cuotas", formattedSOAPResponse));
            accountResponse.setAdelantosLimites(getTagValue("Adelantos", formattedSOAPResponse));
            accountResponse.setPrestamosLimites(getTagValue("Prestamos", formattedSOAPResponse));
            accountResponse.setFechaVencimiento(getTagValue("FechaVencimiento", formattedSOAPResponse));
            accountResponse.setSaldo(getTagValue("Saldo", formattedSOAPResponse));
            accountResponse.setPagoMinimo(getTagValue("PagoMinimo", formattedSOAPResponse));
            accountResponse.setSaldoDolar(getTagValue("SaldoDolar", formattedSOAPResponse));

            return new StatusAccountResponse(accountResponse.getCodigo(), accountResponse.getDescripcion(), accountResponse.getNumero(), accountResponse.getCodigoEstado(), accountResponse.getDescripcionEstado(), accountResponse.getCodigoEntidad(), accountResponse.getDescripcionEntidad(), accountResponse.getSucursal(), accountResponse.getCodigoProducto(), accountResponse.getDescripcionProducto(), accountResponse.getCodigoPais(), accountResponse.getDescripcionPais(), accountResponse.getCodigoMoneda(), accountResponse.getDescripcionMoneda(), accountResponse.getVIP(), accountResponse.getHCC(), accountResponse.getULC(), accountResponse.getMCC(), accountResponse.getMomentoRenewal(), accountResponse.getMomentoUltimaActualizacion(), accountResponse.getMomentoUltimaOperacionAprobada(), accountResponse.getMomentoUltimaOperacionDenegada(), accountResponse.getMomentoUltimoBloqueo(), accountResponse.getMomentoUltimoDesbloqueo(), accountResponse.getComprasDisponibles(), accountResponse.getCuotasDisponibles(), accountResponse.getAdelantosDisponibles(), accountResponse.getPrestamosDisponibles(), accountResponse.getComprasLimites(), accountResponse.getCuotasLimites(), accountResponse.getAdelantosLimites(), accountResponse.getPrestamosLimites(), accountResponse.getFechaVencimiento(), accountResponse.getSaldo(), accountResponse.getPagoMinimo(), accountResponse.getSaldoDolar());

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            throw new MalformedURLException();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IOException();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception();
        }
    }

    public static String getTagValue(String tagName, String xml) {
        return xml.split("<" + tagName + ">")[1].split("</" + tagName + ">")[0];
    }

    private static void ignoreSSL() {
        try {
            ////////////////////////////////////////////////////////////////
            //SE COLOCAR PARA IGNORAR SSL
            ///////////////////////////////////////////////////////////////
            XTrustProvider.install();
            final String TEST_URL = Constants.URL_PROD_WS;
            URL url = new URL(TEST_URL);
            HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
            httpsCon.setConnectTimeout(CONNECTION_TIMEOUT);
            httpsCon.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            httpsCon.connect();
            InputStream is = httpsCon.getInputStream();
            int nread = 0;
            byte[] buf = new byte[8192];
            while ((nread = is.read(buf)) != -1) {
                //System.out.write(buf, 0, nread);
            }
            ////////////////////////////////////////////////////////////////
            //SE COLOCAR PARA IGNORAR SSL
            ///////////////////////////////////////////////////////////////
        } catch (MalformedURLException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    // format the XML in pretty String
    private static String formatXML(String unformattedXml) {
        try {
            Document document = parseXmlFile(unformattedXml);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", 3);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            transformer.transform(source, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    // parse XML

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
