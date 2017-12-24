
package com.coll.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.coll.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetHtmlMetaResponseReturn_QNAME = new QName("http://webservice.coll.com", "return");
    private final static QName _GetHtmlMetaHref_QNAME = new QName("http://webservice.coll.com", "href");
    private final static QName _GetDivideWordContext_QNAME = new QName("http://webservice.coll.com", "context");
    private final static QName _GetBase64ImgAddress_QNAME = new QName("http://webservice.coll.com", "imgAddress");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.coll.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDivideWord }
     * 
     */
    public GetDivideWord createGetDivideWord() {
        return new GetDivideWord();
    }

    /**
     * Create an instance of {@link GetArrayDivideWords }
     * 
     */
    public GetArrayDivideWords createGetArrayDivideWords() {
        return new GetArrayDivideWords();
    }

    /**
     * Create an instance of {@link GetArrayDivideWordsResponse }
     * 
     */
    public GetArrayDivideWordsResponse createGetArrayDivideWordsResponse() {
        return new GetArrayDivideWordsResponse();
    }

    /**
     * Create an instance of {@link GetBase64Response }
     * 
     */
    public GetBase64Response createGetBase64Response() {
        return new GetBase64Response();
    }

    /**
     * Create an instance of {@link GetDivideWordResponse }
     * 
     */
    public GetDivideWordResponse createGetDivideWordResponse() {
        return new GetDivideWordResponse();
    }

    /**
     * Create an instance of {@link GetHtmlMeta }
     * 
     */
    public GetHtmlMeta createGetHtmlMeta() {
        return new GetHtmlMeta();
    }

    /**
     * Create an instance of {@link GetBase64 }
     * 
     */
    public GetBase64 createGetBase64() {
        return new GetBase64();
    }

    /**
     * Create an instance of {@link GetHtmlMetaResponse }
     * 
     */
    public GetHtmlMetaResponse createGetHtmlMetaResponse() {
        return new GetHtmlMetaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "return", scope = GetHtmlMetaResponse.class)
    public JAXBElement<String> createGetHtmlMetaResponseReturn(String value) {
        return new JAXBElement<String>(_GetHtmlMetaResponseReturn_QNAME, String.class, GetHtmlMetaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "href", scope = GetHtmlMeta.class)
    public JAXBElement<String> createGetHtmlMetaHref(String value) {
        return new JAXBElement<String>(_GetHtmlMetaHref_QNAME, String.class, GetHtmlMeta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "return", scope = GetBase64Response.class)
    public JAXBElement<String> createGetBase64ResponseReturn(String value) {
        return new JAXBElement<String>(_GetHtmlMetaResponseReturn_QNAME, String.class, GetBase64Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "context", scope = GetDivideWord.class)
    public JAXBElement<String> createGetDivideWordContext(String value) {
        return new JAXBElement<String>(_GetDivideWordContext_QNAME, String.class, GetDivideWord.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "return", scope = GetDivideWordResponse.class)
    public JAXBElement<String> createGetDivideWordResponseReturn(String value) {
        return new JAXBElement<String>(_GetHtmlMetaResponseReturn_QNAME, String.class, GetDivideWordResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "imgAddress", scope = GetBase64 .class)
    public JAXBElement<String> createGetBase64ImgAddress(String value) {
        return new JAXBElement<String>(_GetBase64ImgAddress_QNAME, String.class, GetBase64 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.coll.com", name = "return", scope = GetArrayDivideWordsResponse.class)
    public JAXBElement<String> createGetArrayDivideWordsResponseReturn(String value) {
        return new JAXBElement<String>(_GetHtmlMetaResponseReturn_QNAME, String.class, GetArrayDivideWordsResponse.class, value);
    }

}
