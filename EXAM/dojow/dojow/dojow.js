function display(element) {
  alert("Loading weather report " + element.innerText);
}
var cookies = document.querySelector(".cookies");
function deletee() {
  cookies.remove();
}

var temperature = document.querySelectorAll(".p-1");

function temp(element) {
  var temp;
  if (element.value === "Celsius") {
    for (var i = 0; i < temperature.length; i++) {
      temp = (parseInt(temperature[i].innerText) - 32) / 1.8;
      temperature[i].innerText = Math.round(temp);
    }
  } else {
    for (var i = 0; i < temperature.length; i++) {
      temp = parseInt(temperature[i].innerText) * 1.8 + 32;
      temperature[i].innerText = Math.round(temp);
    }
  }
}
aws;
