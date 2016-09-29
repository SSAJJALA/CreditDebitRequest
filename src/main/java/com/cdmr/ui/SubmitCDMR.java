package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.requisition.SaveRequisition;

/**
 * Created by Siva Sajjala on 9/29/16.
 */
public class SubmitCDMR {
    private CDMR cdmr;

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

            message = "Requisition " + reqID + " submitted succesfully";
        } catch (Exception e) {
            message = "Unable to submit the requisition. Please contact the help desk";
        }

        return message;
    }

}
