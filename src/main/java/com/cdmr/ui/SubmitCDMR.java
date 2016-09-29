package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.Task.QueueTask;
import com.cdmr.requisition.SaveRequisition;
import org.apache.log4j.Logger;

/**
 * Created by Siva Sajjala on 9/29/16.
 */
public class SubmitCDMR {
    private CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    public SubmitCDMR() {
    }

    public SubmitCDMR(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public String saveCDMR() {
        String message = null;
        SaveRequisition save = new SaveRequisition(cdmr);

        try {
            int reqID = save.save();

            if (reqID != 0 ) {

                message = "Requisition " + reqID + " submitted succesfully";
                log.info(message);
            } else {
                message = "Unable to submit the requisition. Please contact the help desk";
                log.info(message);
            }

        } catch (Exception e) {
            message = "Unable to submit the requisition. Please contact the help desk";
            log.info(message);
        }

        return message;
    }

}
