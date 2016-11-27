/**
 * Java script that validates if there are empty values when form is submitted from create cdmr jsp page
 * Created by Siva Sajjala on 11/19/16.
 */

function checkcustomer() {
    console.log("inside check customer script");

    var cust = document.getElementById("createForm").elements.namedItem("customer").value;
    console.log("customer:" + cust);
    if(cust == '') {
        alert("please enter valid customer number");
        return false;
    } else {
        return true;
    }
}

function checkinvoice() {
    console.log("inside check invoice script");
    checkcustomer();

    var inv = document.getElementById("createForm").elements.namedItem("Invoice").value;
    console.log("invoice:" + inv);
    if(inv == '') {
        alert("please enter valid invoice number");
        return false;
    } else {
        return true;
    }
}

function checkCalcSubmit() {
    console.log("inside check check and calculate script");
    checkinvoice();
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
