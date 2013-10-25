package ca.bcit.infosys.a1.access;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ca.bcit.infosys.a1.model.TimeSheet;

/**
 * Handles CRUD actions for TimeSheet class. In this assignment, we are not
 * writing to the database, hence passing on the responsibility to TimeTable
 * class.
 * 
 * @author shsu
 * @version 0.1
 */
@ApplicationScoped
@Named("TimeSheetManager")
public class TimeSheetManager implements Serializable {

    /** The data source. */
    private List<TimeSheet> dataSource;

    public TimeSheetManager() {
        dataSource = new ArrayList<TimeSheet>();
    }

    /**
     * Gets the data source.
     * 
     * @return the data source
     */
    public List<TimeSheet> getDataSource() {
        return dataSource;
    }

    /**
     * Sets the data source.
     * 
     * @param dataSource
     *            the new data source
     */
    public void setDataSource(final List<TimeSheet> dataSource) {
        this.dataSource = dataSource;
    }
}
