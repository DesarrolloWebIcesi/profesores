/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities.comparators;

import co.edu.icesi.profesores.entities.VrrhProCursoAs;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author 1130619373
 */
public class VrrhProCursoAsComparator implements Comparator<VrrhProCursoAs>{
    
    private Locale locale;
    private Collator collator;

    public VrrhProCursoAsComparator(Locale locale) {
        this.locale=locale;
        this.collator = Collator.getInstance(this.locale);
        collator.setStrength(Collator.PRIMARY);
    }

    @Override
    public int compare(VrrhProCursoAs o1, VrrhProCursoAs o2) {
        if(this.locale.getLanguage().equalsIgnoreCase("es")){
            return this.collator.compare(o1.getNombreMateria(), o2.getNombreMateria());
        }else if(this.locale.getLanguage().equalsIgnoreCase("en")){
            return this.collator.compare(o1.getMatNEng(), o2.getMatNEng());
        }
        return o1.getNombreMateria().compareToIgnoreCase(o2.getNombreMateria());
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        this.collator = Collator.getInstance(this.locale);
        collator.setStrength(Collator.PRIMARY);
    }

    public Collator getCollator() {
        return collator;
    }
    
}
