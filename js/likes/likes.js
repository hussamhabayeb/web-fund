var numberOfLikes = document.querySelector("#likes");
function mylike() {
  numberOfLikes.innerText = parseInt(numberOfLikes.innerText) + 1;
}
function setActive(element) {
  if (element.classList.includes("dark-mode")) {
    element.innerText = "Switch to light mode";
    element.classList.remove("dark-mode");
  } else {
    element.innerText = "Switch to dark mode";
    element.classList.add("dark-mode");
  }
}
