class PurchasePrice {
    constructor(Emp_id, vehicle_type, pass_status, payment) {
        this.Emp_id = Emp_id;
        this.vehicle_type = vehicle_type;
        this.pass_status = pass_status;
        this.payment = payment;
    }
}

let cycle_day = 5;
let cycle_month = 100;
let cycle_year = 500;
let twowheeler_day = 10;
let twowheeler_month = 200;
let twowheeler_year = 1000;
let fourwheeler_day = 20;
let fourwheeler_month = 500;
let fourwheeler_year = 3500;
let types, pass_status, payment;
const price = [];

function typeVehicle(vehicle_type) {
    types = vehicle_type;
    document.getElementById("price").style.display = "block";
    if (vehicle_type == "cycle") {
        document.getElementById("price-type-day").innerHTML = "Cycle";
        document.getElementById("price-type-month").innerHTML = "Cycle";
        document.getElementById("price-type-year").innerHTML = "Cycle";
        document.getElementById("day").innerHTML = cycle_day + " Rs";
        document.getElementById("month").innerHTML = cycle_month + " Rs";
        document.getElementById("year").innerHTML = cycle_year + " Rs";

    }
    else if (vehicle_type == "two-wheeler") {
        document.getElementById("price-type-day").innerHTML = "Two-wheeler";
        document.getElementById("price-type-month").innerHTML = "Two-wheeler";
        document.getElementById("price-type-year").innerHTML = "Two-wheeler";
        document.getElementById("day").innerHTML = twowheeler_day + " Rs ";
        document.getElementById("month").innerHTML = twowheeler_month + " Rs ";
        document.getElementById("year").innerHTML = twowheeler_year + " Rs ";

    }
    else {
        document.getElementById("price-type-day").innerHTML = "Four-wheeler";
        document.getElementById("price-type-month").innerHTML = "Four-wheeler";
        document.getElementById("price-type-year").innerHTML = "Four-wheeler";
        document.getElementById("day").innerHTML = fourwheeler_day + " Rs";
        document.getElementById("month").innerHTML = fourwheeler_month + " Rs";
        document.getElementById("year").innerHTML = fourwheeler_year + " Rs";

    }
}

function changeCurrency() {
    console.log("Calling...");
    var currency = document.getElementById("currency").value;
    if (currency == "RS" && type == "cycle") {
        document.getElementById("day").innerHTML = cycle_day + " Rs";
        document.getElementById("month").innerHTML = cycle_month + " Rs";
        document.getElementById("year").innerHTML = cycle_year + " Rs";
    }
    else if (currency == "RS" && type == "two-wheeler") {
        document.getElementById("day").innerHTML = twowheeler_day + " Rs";
        document.getElementById("month").innerHTML = twowheeler_month + " Rs";
        document.getElementById("year").innerHTML = twowheeler_year + " Rs";
    }
    else if (currency == "RS" && type == "four-wheeler") {
        document.getElementById("day").innerHTML = fourwheeler_day + " Rs";
        document.getElementById("month").innerHTML = fourwheeler_month + " Rs";
        document.getElementById("year").innerHTML = fourwheeler_year + " Rs";
    }
    else if (currency == "DOLLAR" && type == "cycle") {
        document.getElementById("day").innerHTML = (cycle_day * 0.014).toFixed(2) + " $";
        document.getElementById("month").innerHTML = (cycle_month * 0.014).toFixed(2) + " $";
        document.getElementById("year").innerHTML = (cycle_year * 0.014).toFixed(2) + " $";
    }
    else if (currency == "DOLLAR" && type == "two-wheeler") {
        document.getElementById("day").innerHTML = (twowheeler_day * 0.014).toFixed(2) + " $";
        document.getElementById("month").innerHTML = (twowheeler_month * 0.014).toFixed(2) + " $";
        document.getElementById("year").innerHTML = (twowheeler_year * 0.014).toFixed(2) + " $";
    }
    else if (currency == "DOLLAR" && type == "four-wheeler") {
        document.getElementById("day").innerHTML = (fourwheeler_day * 0.014).toFixed(2) + " $";
        document.getElementById("month").innerHTML = (fourwheeler_month * 0.014.toFixed(2)) + " $";
        document.getElementById("year").innerHTML = (fourwheeler_year * 0.014).toFixed(2) + " $";
    }
    else if (currency == "YEN" && type == "cycle") {
        document.getElementById("day").innerHTML = (cycle_day / .51).toFixed(2) + " Y";
        document.getElementById("month").innerHTML = (cycle_month / .51.toFixed(2)) + " Y";
        document.getElementById("year").innerHTML = (cycle_year / .51).toFixed(2) + " Y";
    }
    else if (currency == "YEN" && type == "two-wheeler") {
        document.getElementById("day").innerHTML = (twowheeler_day / .51).toFixed(2) + " Y";
        document.getElementById("month").innerHTML = (twowheeler_month / .51).toFixed(2) + " Y";
        document.getElementById("year").innerHTML = (twowheeler_year / .51).toFixed(2) + " Y";
    }
    else if (currency == "YEN" && type == "four-wheeler") {
        document.getElementById("day").innerHTML = (fourwheeler_day / .51).toFixed(2) + " Y";
        document.getElementById("month").innerHTML = (fourwheeler_month / .51).toFixed(2) + " Y";
        document.getElementById("year").innerHTML = (fourwheeler_year / .51).toFixed(2) + " Y";
    }
}

function purchase_day() {
    pass_status = "day";
    payment = convertUSD("day");
    price.push(new PurchasePrice(employee[0].id, types, pass_status, payment));
    document.getElementById("currency-declare").style.display = "none";
    document.getElementById("day-status").style.display = "none";
    document.getElementById("month-status").style.display = "none";
    document.getElementById("year-status").style.display = "none";
    text = "Vehicle Type-" + type + " pass-Day";
    document.getElementById("detail").innerHTML = text;
}
function purchase_month() {
    pass_status = "month";
    payment = convertUSD("month");
    price.push(new PurchasePrice(employee[0].id, types, pass_status, payment));
    document.getElementById("currency-declare").style.display = "none";
    document.getElementById("day-status").style.display = "none";
    document.getElementById("month-status").style.display = "none";
    document.getElementById("year-status").style.display = "none";
    text = "Vehicle Type-" + type + " pass-Month";
    document.getElementById("detail").innerHTML = text;
}
function purchase_year() {
    pass_status = "year";
    payment = convertUSD("year");
    price.push(new PurchasePrice(employee[0].id, types, pass_status, payment));
    document.getElementById("currency-declare").style.display = "none";
    document.getElementById("day-status").style.display = "none";
    document.getElementById("month-status").style.display = "none";
    document.getElementById("year-status").style.display = "none";
    text = "Vehicle Type-" + type + " pass-Year";
    document.getElementById("detail").innerHTML = text;
}

function convertUSD(package) {
    if (package == "day") {
        if (types == "cycle")
            return (cycle_day / 70).toFixed(2);
        if (types == "two-wheeler")
            return (twowheeler_day / 70).toFixed(2);
        else
            return (fourwheeler_day / 70).toFixed(2);
    }
    if (package == "month") {
        if (types == "cycle")
            return (cycle_month / 70).toFixed(2);
        if (types == "two-wheeler")
            return (twowheeler_month / 70).toFixed(2);
        else
            return (fourwheeler_year / 70).toFixed(2);
    }
    if (package == "year") {
        if (types == "cycle")
            return (cycle_year / 70).toFixed(2);
        if (types == "two-wheeler")
            return (twowheeler_year / 70).toFixed(2);
        else
            return (fourwheeler_year / 70).toFixed(2);
    }
}

