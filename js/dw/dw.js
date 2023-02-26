function alr(t) {
  window.alert("reloading weather report for " + t.innerText);
}

function del(x) {
  document.querySelector(x).remove();
}
var k = document.querySelectorAll(".p1");
function chg(j) {
  if (j.value === "farenheit") {
    for (var i = 0; i < k.length; i++) {
      var temp = k[i].innerText;
      var f = temp * 1.8 + 32;
      k[i].innerText = Math.round(f);
    }
  }

  if (j.value === "celcius") {
    for (var i = 0; i < k.length; i++) {
      var temp = k[i].innerText;
      var f = (temp - 32) * 0.55;
      k[i].innerText = Math.round(f);
    }
  }
  console.log(j.value);
}
