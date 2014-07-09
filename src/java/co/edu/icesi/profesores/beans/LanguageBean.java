/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * @author David Andrés Manzano Herrera - damanzano
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String localeCode;
    private Locale currentLocale;
    private static Map<String, Object> supportedLocales;

    static {
        supportedLocales = new LinkedHashMap<String, Object>();
        Iterator<Locale> contextLocales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        Locale defaultContextLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        supportedLocales.put(defaultContextLocale.getDisplayLanguage(), defaultContextLocale);
        while (contextLocales.hasNext()) {
            Locale supportedLocale = contextLocales.next();
            if (!supportedLocale.equals(defaultContextLocale)) {
                supportedLocales.put(supportedLocale.getDisplayLanguage(), supportedLocale);
            }
        }
    }

    /**
     * Creates a new instance of LanguageBean
     */
    public LanguageBean() {
        defineLocale();
    }

    public String getLocaleCode() {
        defineLocale();
        return this.localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode=localeCode;
    }

    public Map<String, Object> getSupportedLocalesInMap() {
        return supportedLocales;
    }

    public Locale getCurrentLocale() {
        
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    //Locale change listener
    public void languageChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        this.currentLocale = getMappedLocale(newLocaleValue);
        this.localeCode = currentLocale.getLanguage();
        FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
    }

    /**
     * Get the Locale object that match the localeCode passed as parameter
     *
     * @param localeCode the code of the searched language
     */
    private Locale getMappedLocale(String localeCode) {
        //loop supportedLocales Map to compare the locale code
        for (Map.Entry<String, Object> entry : supportedLocales.entrySet()) {
            if (entry.getValue().toString().equals(localeCode)) {
                return (Locale) entry.getValue();
                //this.localeCode=currentLocale.getLanguage();
                //FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
        return currentLocale;
    }
    
    /** 
     * Define wheather the locale is taked from session or from request. By default if no locale request parameter is received session´s locale is taken
     */
    private void defineLocale(){
        String newlocaleCode =((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("locale");
        if( null!=newlocaleCode && !"".equalsIgnoreCase(newlocaleCode)){
            this.localeCode=newlocaleCode;
            this.currentLocale=getMappedLocale(localeCode);
            FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
        }else{
            this.currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            this.localeCode = this.currentLocale.getLanguage();
        }
    } 
}
