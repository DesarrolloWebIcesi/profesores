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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
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
        Locale defaultContextLocale=FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
        supportedLocales.put(defaultContextLocale.getDisplayLanguage(), defaultContextLocale);
        while (contextLocales.hasNext()) {
            Locale supportedLocale = contextLocales.next();
            if(!supportedLocale.equals(defaultContextLocale)){
                supportedLocales.put(supportedLocale.getDisplayLanguage(), supportedLocale);
            }
        }
    }

    /**
     * Creates a new instance of LanguageBean
     */
    public LanguageBean() {
        this.currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        this.localeCode = this.currentLocale.getDisplayLanguage();
    }

    public String getLocaleCode() {
        return this.localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
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

        //loop supportedLocales Map to compare the locale code
        for (Map.Entry<String, Object> entry : supportedLocales.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                this.currentLocale=(Locale) entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }
}
