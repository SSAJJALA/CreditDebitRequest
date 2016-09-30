package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.requisition.UpdateRequisition;
import org.apache.log4j.Logger;

/**
 * Created by Siva Sajjala on 9/30/16.
 */
public class UpdateCDMRDetails {

    public CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    public UpdateCDMRDetails(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public String updateCDMR() {
        UpdateRequisition update = new UpdateRequisition(cdmr);
        update.updateCDMR();
        log.info("CDMR Updated Succesfully");
        return "CDMR Updated Succesfully";
    }
}
