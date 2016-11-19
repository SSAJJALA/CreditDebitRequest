package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.requisition.UpdateRequisition;
import org.apache.log4j.Logger;

/**
 * RouteCDMR program is the routing engine for CDMR application. This class identifies the next approver and assigns the task in the approver's inbox.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-30
 */
public class UpdateCDMRDetails {

    public CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * arg constructor
     * @param cdmr
     */
    public UpdateCDMRDetails(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    /**
     * update cdmr details
     * @return string message
     */
    public String updateCDMR() {
        UpdateRequisition update = new UpdateRequisition(cdmr);
        update.updateCDMR();
        log.info("CDMR Updated Succesfully");
        return "CDMR Updated Succesfully";
    }
}
