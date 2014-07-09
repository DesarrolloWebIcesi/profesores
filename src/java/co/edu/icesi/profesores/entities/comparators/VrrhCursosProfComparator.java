/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.entities.comparators;

import co.edu.icesi.profesores.entities.VrrhCursosProf;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author David Andrés Manzano Herrera
 */
public class VrrhCursosProfComparator implements Comparator<VrrhCursosProf> {

    private Locale locale;
    private Collator collator;

    /**
     *
     * @param locale
     */
    public VrrhCursosProfComparator(Locale locale) {
        this.locale=locale;
        this.collator = Collator.getInstance(this.locale);
        collator.setStrength(Collator.PRIMARY);
    }
    
    @Override
    public int compare(VrrhCursosProf o1, VrrhCursosProf o2) {
        if(this.locale.getLanguage().equalsIgnoreCase("es")){
            return this.collator.compare(o1.getMateriaNombre(), o2.getMateriaNombre());
        }else if(this.locale.getLanguage().equalsIgnoreCase("en")){
            return this.collator.compare(o1.getMatNEng(), o2.getMatNEng());
        }
        return o1.getMateriaNombre().compareToIgnoreCase(o2.getMateriaNombre());
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
