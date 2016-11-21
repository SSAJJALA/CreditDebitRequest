/**
 * Java script that validates if there are empty values when form is submitted from create cdmr jsp page
 * Created by Siva Sajjala on 11/19/16.
 */

function checkcustomer() {
    var cust = document.forms["createCDMR"]["customer"].value;
    if(cust == "") {
        alert("please enter valid customer number");
        return false;
    } else {
        return true;
    }
}

function checkinvoice() {
    var inv = document.forms["createCDMR"]["Invoice"].value;
    if(inv == "") {
        alert("please enter valid invoice number");
        return false;
    } else {
        return true;
    }
}

function checkcalculate() {
    var adjQty = document.forms["createCDMR"]["adjQty"].value;
    var creditdebitFlg = document.forms["createCDMR"]["creditDebit"].value;

    if(adjQty == "" || creditdebitFlg == "") {
        if (adjQty == "") {
            alert("please enter valid adjustment qty");
        }
        if (creditdebitFlg == "") {
            alert("please choose credit or debit flag");
        }
        return false;

    } else {
        return true;
    }
}

function checksubmit() {
    var adjQty = document.forms["createCDMR"]["adjQty"].value;
    var creditdebitFlg = document.forms["createCDMR"]["creditDebit"].value;

    if(adjQty == "" || creditdebitFlg == "") {
        if (adjQty == "") {
            alert("please enter valid adjustment qty");
        }
        if (creditdebitFlg == "") {
            alert("please choose credit or debit flag");
        }
        return false;

    } else {
        return true;
    }
}

function checkCalcSubmit() {
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
