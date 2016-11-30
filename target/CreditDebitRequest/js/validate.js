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
    /**
    var table = document.getElementById("datatable2").tBodies.rows;
    var fault = "false";
    for (i=0;i<table.length;i++) {
        var adjQty = table[i].cells[4].innerHTML;
        console.log("Adj qty:" + adjQty);
        var creditDebitFlg = table[i].cells[11].innerHTML;
        console.log("creditDebitFlg:" + creditDebitFlg);
        if (adjQty == "" || creditDebitFlg == "") {
            fault = "true";
            break;
        }

    }

    var invtable = document.getElementById("datatable1");
    console.log("datatable1:" + invtable);

    var table = document.getElementById("datatable2");

    //var table = document.getElementById("createForm").elements.namedItem();

    console.log("datatable2:" + table);
    for (var i=0;i<table.tBodies.length;i++) {
        var tbody = table.tBodies[i];
        console.log("tbody:" + tbody);
        for (var j=0;j<tbody.rows.length;j++) {
            alert("inside tbody");
            var row = tbody.rows[j];
            var adjQty = row.cells[4];
            var creditDebitFlg = row.cells[11];
            var rc = row.cells[5];
            var fault = "false";

            console.log("Adj qty:" + adjQty);
            console.log("creditDebitFlg:" + creditDebitFlg);
            console.log("Reason code:" + rc);

            if (adjQty == "" || creditDebitFlg == "" || rc == "") {
                fault = "true";
                break;
            }
        }
    }
     **/

    //var trs = document.querySelectorAll("#datatable2 tbody");
    var tbody = document.querySelectorAll("#datatable2 tbody");
    var fault = "false";

    for (i=0;i<tbody.length;i++) {

        alert("inside tbody");
        var tr = tbody[i].querySelectorAll("tr");
        for (j=0;j<tr.length;j++){
            alert("inside tr");
            var td = tr[j].querySelectorAll("td");
            var adjQty = td[4].firstChild.value;
            var rc = td[5].querySelector("[selected]").innerHTML;
            var creditDebitFlg = td[11].querySelector("[selected]").innerHTML;

            console.log("Adj qty:" + adjQty);
            console.log("Reason code:" + rc);
            console.log("creditDebitFlg:" + creditDebitFlg);
            alert("Adj Qty:" + adjQty);
            alert("rc:" + rc);
            alert("CreditDebitFlag:" + creditDebitFlg);
            if (adjQty == '' || creditDebitFlg == '' || rc == '') {
                alert("making fault as true");
                fault = "true";
                break;
            }
        }

    }



    /**
    console.log("trs:" + trs);
    alert("inside tbody");
    var fault = "false";
    for (i = 0 ; i < trs.length ; i++) {
        var tds = trs.querySelectorAll('td');
        console.log("td:" + tds);
        var adjQty = tds[4].innerHTML;
        console.log("Adj qty:" + adjQty);
        var rc = tds[5].innerHTML;
        console.log("Reason code:" + rc);
        var creditDebitFlg = tds[11].innerHTML;
        console.log("creditDebitFlg:" + creditDebitFlg);

        if (adjQty == "" || creditDebitFlg == "" || rc == "") {
            fault = "true";
            break;
        }


    }
     **/

    if (fault = "true") {
        alert("please enter valid adjustment qty/reason code/credit debit flag");
        return false;
    } else {
        return true;
    }
}
