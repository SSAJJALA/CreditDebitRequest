/**
 * Java script that validates if there are empty values when form is submitted from create cdmr jsp page
 * Created by Siva Sajjala on 11/26/16.
 */

function checkform() {

    console.log("inside validate form java script");
    if (document.getElementById("btn_retCust").valueOf() != null ) {
        console.log("inside check customer script");
        //var cust = document.forms["createCDMR"]["customer"].value();
        var cust = document.getElementById("customer").valueOf();
        console.log("customer:" + cust);
        if(cust == "") {
            alert("please enter valid customer number");
            return false;
        } else {
            return true;
        }
    }

    if (document.getElementById("btn_retInv").valueOf() != null) {
        console.log("inside check invoice script");
        //var inv = document.forms["createCDMR"]["Invoice"].value();
        var inv = document.getElementById("Invoice").valueOf();
        if(inv == "") {
            alert("please enter valid invoice number");
            return false;
        } else {
            return true;
        }

    }

    if (document.getElementById("btn_calculate").valueOf() != null || document.getElementById("btn_submit").valueOf() != null) {
        var table = document.getElementById("datatable2").rows;
        var fault = "false";
        for (i=0;i<table.length;i++) {
            var adjQty = table[i].cells[4].innerHTML;
            var creditDebitFlg = table[i].cells[11].innerHTML;
            if (adjQty == "" || creditDebitFlg == "") {
                fault = "true";
                break;
            }

        }

        if (fault = "true") {
            alert("please enter valid adjustment qty/credit debit flag");
            return false;
        } else {
            return true;
        }
    }
}