package co.edu.icesi.profesores.beans;

import co.edu.icesi.profesores.entities.StdPerson;
import co.edu.icesi.profesores.beans.util.JsfUtil;
import co.edu.icesi.profesores.beans.util.PaginationHelper;
import co.edu.icesi.profesores.controllers.StdPersonJpaController;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.Persistence;

@ManagedBean(name = "stdPersonController")
@SessionScoped
public class StdPersonController implements Serializable {

    private StdPerson current;
    private DataModel items = null;
    private StdPersonJpaController jpaController = null;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public StdPersonController() {
    }

    public StdPerson getSelected() {
        if (current == null) {
            current = new StdPerson();
            current.setStdPersonPK(new co.edu.icesi.profesores.entities.StdPersonPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private StdPersonJpaController getJpaController() {
        if (jpaController == null) {
            jpaController = new StdPersonJpaController(Persistence.createEntityManagerFactory("profesoresPU"));
        }
        return jpaController;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getJpaController().getStdPersonCount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getJpaController().findStdPersonEntities(getPageSize(), getPageFirstItem()));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (StdPerson) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }
   
    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findStdPersonEntities(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findStdPersonEntities(), true);
    }

    @FacesConverter(forClass = StdPerson.class)
    public static class StdPersonControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StdPersonController controller = (StdPersonController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "stdPersonController");
            return controller.getJpaController().findStdPerson(getKey(value));
        }

        co.edu.icesi.profesores.entities.StdPersonPK getKey(String value) {
            co.edu.icesi.profesores.entities.StdPersonPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.icesi.profesores.entities.StdPersonPK();
            key.setIdOrganization(values[0]);
            key.setStdIdPerson(values[1]);
            return key;
        }

        String getStringKey(co.edu.icesi.profesores.entities.StdPersonPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getIdOrganization());
            sb.append(SEPARATOR);
            sb.append(value.getStdIdPerson());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof StdPerson) {
                StdPerson o = (StdPerson) object;
                return getStringKey(o.getStdPersonPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + StdPerson.class.getName());
            }
        }
    }
}