class Vehicle {

    constructor(company_name, model, type, vehicle_number, emp_id, identification) {
        this.company_name = company_name;
        this.model = model;
        this.type = type;
        this.vehicle_number = vehicle_number;
        this.emp_id = emp_id;
        this.identification = identification;
    }
}

function vehicleBrand(textbox) {
    company_name = textbox.value;
    document.getElementById("before-vehicle-name").style.display = 'none';
    document.getElementById("after-each-vehicle-data").style.display = 'block';
    document.getElementById("before-vehicle-model").style.display = 'block';
    let text = "Hii " + employee_name + " Can I Know your Vehicle Model";
    document.getElementById("name-label-vehicle").innerHTML = text;
}
function vehicleModel(textbox) {
    model = textbox.value;
    document.getElementById("before-vehicle-model").style.display = 'none';
    document.getElementById("after-each-vehicle-data").style.display = 'block';
    document.getElementById("before-vehicle-type").style.display = 'block';
    let text = "Hii " + employee_name + " Can I Know your Vehicle type";
    document.getElementById("name-label-vehicle").innerHTML = text;
}


function vehicleType(textbox) {
    type = textbox.value;
    document.getElementById("before-vehicle-type").style.display = 'none';
    document.getElementById("after-each-vehicle-data").style.display = 'block';
    document.getElementById("before-vehicle-number").style.display = 'block';
    let text = "Hii " + employee_name + " Can I know Vehicle Number";
    document.getElementById("name-label-vehicle").innerHTML = text;
}

function vehicleNumber(textbox) {
    vehicle_number = textbox.value;
    document.getElementById("before-vehicle-number").style.display = 'none';
    document.getElementById("after-each-vehicle-data").style.display = 'block';
    document.getElementById("before-identification").style.display = 'block';
    let text = "Hii " + employee_name + " Can I know Identification mark";
    document.getElementById("name-label-vehicle").innerHTML = text;
}

function vehicleIdentification(textbox) {
    identification = textbox.value;
    document.getElementById("before-identification").style.display = 'none';
    document.getElementById("after-each-vehicle-data").style.display = 'block';
    document.getElementById("disable-button-vehicle").style.display = 'block';
    let text = "Hii " + employee_name + " Submit the form";
    document.getElementById("name-label-vehicle").innerHTML = text;
}
const vehicle = [];
let company_name, model, type, vehicle_number, identification, emp_id;

function setVehicle() {
    emp_id = employee[0].id;
    vehicle.push(new Vehicle(company_name, model, type, vehicle_number, emp_id, identification));
    document.getElementById("vehicle-form").style.display = "none";
    let text = "Vehicle Number-" + vehicle[0].vehicle_number;
    document.getElementById("vehicle-description").innerHTML = text;
    typeVehicle(type);

}