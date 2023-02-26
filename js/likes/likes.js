var x = document.querySelector("#jooj").innerText;
console.log(x);
function mylike(r) {
  x++;
  console.log(x);
  document.querySelector("#jooj").innerText = x;
}
