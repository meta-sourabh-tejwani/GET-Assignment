var cycle_day=5;
var cycle_month=100;
var cycle_year=500;
var twowheeler_day=10;
var twowheeler_month=200;
var twowheeler_year=1000;
var fourwheeler_day=20;
var fourwheeler_month=500;
var fourwheeler_year=3500;
var type,pass_status,payment;
var prices;

function typeVehicle(vehicle_type)
{
    type=vehicle_type;
    document.getElementById("price").style.display="block";
    if(vehicle_type=="cycle")
    {
        document.getElementById("price-type-day").innerHTML="Cycle";
        document.getElementById("price-type-month").innerHTML="Cycle";
        document.getElementById("price-type-year").innerHTML="Cycle";
        document.getElementById("day").innerHTML=cycle_day+" Rs";
        document.getElementById("month").innerHTML=cycle_month+" Rs";
        document.getElementById("year").innerHTML=cycle_year+" Rs";

    }
    else if(vehicle_type=="two-wheeler")
    {
        document.getElementById("price-type-day").innerHTML="Two-wheeler";
        document.getElementById("price-type-month").innerHTML="Two-wheeler";
        document.getElementById("price-type-year").innerHTML="Two-wheeler";
        document.getElementById("day").innerHTML=twowheeler_day+" Rs ";
        document.getElementById("month").innerHTML=twowheeler_month+" Rs ";
        document.getElementById("year").innerHTML=twowheeler_year+" Rs ";
    
    }
    else{
        document.getElementById("price-type-day").innerHTML="Four-wheeler";
        document.getElementById("price-type-month").innerHTML="Four-wheeler";
        document.getElementById("price-type-year").innerHTML="Four-wheeler";
        document.getElementById("day").innerHTML=fourwheeler_day+" Rs";
        document.getElementById("month").innerHTML=fourwheeler_month+" Rs";
        document.getElementById("year").innerHTML=fourwheeler_year+" Rs";

    }
}

function changeCurrency()
{
        var currency=document.getElementById("currency").value;
        if(currency=="RS" && type=="cycle")
        {
            document.getElementById("day").innerHTML=cycle_day+" Rs";
            document.getElementById("month").innerHTML=cycle_month+" Rs";
            document.getElementById("year").innerHTML=cycle_year+" Rs";
        }
        else if(currency=="RS" && type=="two-wheeler")
        {
            document.getElementById("day").innerHTML=twowheeler_day+" Rs";
            document.getElementById("month").innerHTML=twowheeler_month+" Rs";
            document.getElementById("year").innerHTML=twowheeler_year+" Rs";
        }
        else if(currency=="RS" && type=="four-wheeler")
        {
            document.getElementById("day").innerHTML=fourwheeler_day+" Rs";
            document.getElementById("month").innerHTML=fourwheeler_month+" Rs";
            document.getElementById("year").innerHTML=fourwheeler_year+" Rs";
        }
        else if(currency=="DOLLAR" && type=="cycle")
        {
            document.getElementById("day").innerHTML=(cycle_day*0.014).toFixed(2)+" $";
            document.getElementById("month").innerHTML=(cycle_month*0.014).toFixed(2)+" $";
            document.getElementById("year").innerHTML=(cycle_year*0.014).toFixed(2)+" $";
        }
        else if(currency=="DOLLAR" && type=="two-wheeler")
        {
            document.getElementById("day").innerHTML=(twowheeler_day*0.014).toFixed(2)+" $";
            document.getElementById("month").innerHTML=(twowheeler_month*0.014).toFixed(2)+" $";
            document.getElementById("year").innerHTML=(twowheeler_year*0.014).toFixed(2)+" $";
        }
        else if(currency=="DOLLAR" && type=="four-wheeler")
        {
            document.getElementById("day").innerHTML=(fourwheeler_day*0.014).toFixed(2)+" $";
            document.getElementById("month").innerHTML=(fourwheeler_month*0.014.toFixed(2))+" $";
            document.getElementById("year").innerHTML=(fourwheeler_year*0.014).toFixed(2)+" $";
        }
        else if(currency=="YEN" && type=="cycle")
        {
            document.getElementById("day").innerHTML=(cycle_day/.51).toFixed(2)+" Y";
            document.getElementById("month").innerHTML=(cycle_month/.51.toFixed(2))+" Y";
            document.getElementById("year").innerHTML=(cycle_year/.51).toFixed(2)+" Y";
        }
        else if(currency=="YEN" && type=="two-wheeler")
        {
            document.getElementById("day").innerHTML=(twowheeler_day/.51).toFixed(2)+" Y";
            document.getElementById("month").innerHTML=(twowheeler_month/.51).toFixed(2)+" Y";
            document.getElementById("year").innerHTML=(twowheeler_year/.51).toFixed(2)+" Y";
        }
        else if(currency=="YEN" && type=="four-wheeler")
        {
            document.getElementById("day").innerHTML=(fourwheeler_day/.51).toFixed(2)+" Y";
            document.getElementById("month").innerHTML=(fourwheeler_month/.51).toFixed(2)+" Y";
            document.getElementById("year").innerHTML=(fourwheeler_year/.51).toFixed(2)+" Y";
        }
}


function purchase_day()
{
    pass_status="day";
    payment=convertUSD("day");
    prices={"id":employees["id"],"vehicle_type":type,"pass_status":pass_status,"payment_complete":payment};
    document.getElementById("currency-declare").style.display="none";
    document.getElementById("day-status").style.display="none";
    document.getElementById("month-status").style.display="none";
    document.getElementById("year-status").style.display="none";
    text="Vehicle Type-"+type+" pass-Day";
    document.getElementById("detail").innerHTML=text;
}
function purchase_month()
{
    pass_status="month";
    payment=convertUSD("month");
    prices={"id":employees["id"],"vehicle_type":type,"pass_status":pass_status,"payment_complete":payment};
    document.getElementById("currency-declare").style.display="none";
    document.getElementById("day-status").style.display="none";
    document.getElementById("month-status").style.display="none";
    document.getElementById("year-status").style.display="none";
    text="Vehicle Type-"+type+" pass-Month";
    document.getElementById("detail").innerHTML=text;
}
function purchase_year()
{
    pass_status="year";
    payment=convertUSD("year");
    prices={"id":employees["id"],"vehicle_type":type,"pass_status":pass_status,"payment_complete":payment};
    document.getElementById("currency-declare").style.display="none";
    document.getElementById("day-status").style.display="none";
    document.getElementById("month-status").style.display="none";
    document.getElementById("year-status").style.display="none";
    text="Vehicle Type-"+type+" pass-Year";
    document.getElementById("detail").innerHTML=text;
}

function convertUSD(package)
{
    if(package=="day")
    {
        if(type=="cycle")
        return (cycle_day/70).toFixed(2);
        if(type=="two-wheeler")
        return (twowheeler_day/70).toFixed(2);
        else
        return (fourwheeler_day/70).toFixed(2);
    }
    if(package=="month")
    {
        if(type=="cycle")
        return (cycle_month/70).toFixed(2);
        if(type=="two-wheeler")
        return (twowheeler_month/70).toFixed(2);
        else
        return (fourwheeler_year/70).toFixed(2);
    }
    if(package=="year")
    {
        if(type=="cycle")
        return (cycle_year/70).toFixed(2);
        if(type=="two-wheeler")
        return (twowheeler_year/70).toFixed(2);
        else
        return (fourwheeler_year/70).toFixed(2);
    }
}
