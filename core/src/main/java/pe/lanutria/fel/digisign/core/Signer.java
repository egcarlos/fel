/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.lanutria.fel.digisign.core;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

/**
 *
 * @author carlosecheverria
 */
public class Signer {

    //referencia al certificado digital de identidad del firmante
    private X509Certificate certificate;
    //referencia a la llave privada usada para firmar el documento
    private PrivateKey privateKey;
    //tipo de algoritmo de firma utilizado
    private String signatureAlgorithm;
    //tipo de transformacion
    private String transformType;
    //tipo de algoritmo de resumen
    private String digestAlgorithm;
    //signature attributes
    private Map<String, String> signatureAttributes;

    public void sign(Document document) {
        XMLSignature signature = createSignatureObject(document);
        initializeSignatureAttributes(document, signature);
        appendSign(document, signature);
        atachSignature(document, signature);
        addIdentityInformation(signature);
        applySignature(signature);
    }

    private XMLSignature createSignatureObject(Document document) throws SignerException {
        try {
            return new XMLSignature(document, "", signatureAlgorithm);
        } catch (XMLSecurityException ex) {
            throw new SignerException("Unable to create XMLSignature. " + ex.getMessage(), ex);
        }
    }

    private void initializeSignatureAttributes(Document document, XMLSignature signature) throws DOMException {
        //identify the signature element id name
        String signatureElementId = locateSignatureElementId(document);
        signature.getElement().setAttribute("Id", signatureElementId);
        signatureAttributes.forEach((k, v) -> signature.getElement().setAttribute(k, v));
    }

    private String locateSignatureElementId(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void appendSign(Document document, XMLSignature signature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Transforms atachSignature(Document document, XMLSignature signature) throws SignerException {
        try {
            Transforms transforms = new Transforms(document);
            transforms.addTransform(transformType);
            signature.addDocument("", transforms, digestAlgorithm);
            return transforms;
        } catch (TransformationException ex) {
            throw new SignerException("Unable to add transform \"" + transformType + "\".", ex);
        } catch (XMLSignatureException ex) {
            throw new SignerException("Unable to set diggest algorithm \"" + digestAlgorithm + "\".", ex);
        }
    }

    private void addIdentityInformation(XMLSignature signature) throws SignerException {
        try {
            signature.addKeyInfo(certificate);
        } catch (XMLSecurityException ex) {
            throw new SignerException("Unable to add certificate.", ex);
        }
        signature.addKeyInfo(certificate.getPublicKey());
    }

    private void applySignature(XMLSignature signature) throws SignerException {
        try {
            signature.sign(privateKey);
        } catch (XMLSignatureException ex) {
            throw new SignerException("Unable to sign document.", ex);
        }
    }

    public X509Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(X509Certificate certificate) {
        this.certificate = certificate;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public String getTransformType() {
        return transformType;
    }

    public void setTransformType(String transformType) {
        this.transformType = transformType;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public Map<String, String> getSignatureAttributes() {
        return signatureAttributes;
    }

    public void setSignatureAttributes(Map<String, String> signatureAttributes) {
        this.signatureAttributes = signatureAttributes;
    }

}
