
function setEmployeeName(textbox) {
    if (/^[a-zA-Z ]*$/.test(textbox.value) == false) {
      if (/[0-9]+/.test(textbox.value)) {
        alert("Name Does not contain any numeric value");
      } else if (textbox.value.length <= 2) {
        alert("Minimum Character must be 3");
      } else {
        alert("Name Does contain only alphabate");
      }
    } else {
      employee_name = textbox.value;
      document.getElementById("before-name").style.display = 'none';
      document.getElementById("after-each-data").style.display = 'block';
      document.getElementById("before-gender").style.display = 'block';
      var text = "Hii " + employee_name + " Can I Know your gender";
      document.getElementById("name-label-test").innerHTML = text;
    }
  }
  
  function setGender(textbox) {
    employee_gender = textbox.value;
    document.getElementById("before-gender").style.display = 'none';
    document.getElementById("after-each-data").style.display = 'block';
    document.getElementById("before-mail").style.display = 'block';
    var text = "Hii " + employee_name + " Can I Know your mail-id";
    document.getElementById("name-label-test").innerHTML = text;
  }
  
  function setEmployeeMail(textbox) {
    if (/\S+@\S+\.\S+/.test(textbox.value)) {
      email = textbox.value;
      document.getElementById("before-mail").style.display = 'none';
      document.getElementById("after-each-data").style.display = 'block';
      document.getElementById("before-password").style.display = 'block';
      var text = "Hii " + employee_name + " Enter  Strong password";
      document.getElementById("name-label-test").innerHTML = text;
    } else {
      alert("Please Enter Valid email id ");
    }
  }
  
  function setPassword(textbox) {
    if (textbox.value.length < 8) {
      alert("Password minimum length must be 8");
    } else if (/ +/.test(textbox.value)) {
      alert("password does not have white space");
    } else if (/^[a-zA-Z]*$/.test(textbox.value)) {
      alert("Password must contain number and special character");
    } else if (/^[a-zA-Z0-9]*$/.test(textbox.value)) {
      alert("Password must contain special character");
    } else {
      employee_password = textbox.value;
      document.getElementById("before-password").style.display = 'none';
      document.getElementById("after-each-data").style.display = 'block';
      document.getElementById("before-confirm-password").style.display = 'block';
      var text = "Hii " + employee_name + " Please Enter password one more time to Verify password";
      document.getElementById("name-label-test").innerHTML = text;
    }
  }
  
  function checkComplexity(textbox) {
    if (/^[a-zA-Z]*$/.test(textbox.value)) {
      textbox.style.border = "10px solid red";
    } else if (/^[a-zA-Z0-9]*$/.test(textbox.value)) {
      textbox.style.border = "10px solid orange";
    } else {
      textbox.style.border = "10px solid green";
    }
  }
  
  function confirmPassword(textbox) {
    if (textbox.value == employee_password) {
      confirm_password = textbox.value;
      document.getElementById("before-confirm-password").style.display = 'none';
      document.getElementById("after-each-data").style.display = 'block';
      document.getElementById("before-contact").style.display = 'block';
      var text = "Hii " + employee_name + " Can I Know your Contact number";
      document.getElementById("name-label-test").innerHTML = text;
    } else {
      alert("Password Does not match");
    }
  }
  
  function contact(textbox) {
    if (textbox.value.length < 8) {
      alert("Number must be greater than 7");
    } else if (/^[0-9]*$/.test(textbox.value) == false) {
      alert("Number must be digit");
    } else {
      contact_number = textbox.value;
      document.getElementById("before-contact").style.display = 'none';
      document.getElementById("after-each-data").style.display = 'block';
      document.getElementById("disable-button-employee").style.display = 'block';
      var text = "Hii " + employee_name + " Submit the form";
      document.getElementById("name-label-test").innerHTML = text;
    }
  }
  
  var employee_name, employee_gender, email, employee_password, confirm_password, contact_number;
  var employee_id = 1;
  var employees;
  
  function setEmployee() {
    employees={"id":employee_id++,"names":employee_name,"gender":employee_gender,
                  "email":email,"password":employee_password,"contact":contact_number};
   document.getElementById("employee-form").style.display = "none";         
    var text = "Employee id-" + employees["id"];
    document.getElementById("employee-description").innerHTML = text;
    document.getElementById("vehicle").style.display = 'block';
  }
  