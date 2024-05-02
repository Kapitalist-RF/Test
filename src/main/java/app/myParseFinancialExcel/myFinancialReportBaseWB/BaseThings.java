package app.myParseFinancialExcel.myFinancialReportBaseWB;

import java.util.List;

public class BaseThings {

    private List<Thing> thingsList;

    public BaseThings(List<Thing> thingsList) {
        this.thingsList = thingsList;
    }

    public List<Thing> getThingsList() {
        return thingsList;
    }

    public void setThingsList(List<Thing> thingsList) {
        this.thingsList = thingsList;
    }

}
