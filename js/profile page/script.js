var accept1 = document.querySelector("#aa");
var accept2 = document.querySelector("bb");
var badge = document.querySelector(".badge");
var badge1 = document.querySelector(".badge1");
function ad() {
  badge.innerText = parseInt(badge.innerText) - 1;
  accept1.remove();
  badge1.innerText = parseInt(badge1.innerText) + 1;
}
