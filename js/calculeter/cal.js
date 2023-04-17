
var num="";
var eq;
function press(n){
num=num + n.toString();
document.querySelector("#display").innerText=num;
}

var o;
function setOP(OP){
    eq=parseFloat(num);
    num="";
    o=OP;
}

function calculate(){
    if(o==='/'){
        eq=eq/parseFloat(num);

    }
    if(o==='*'){
        eq=eq*parseFloat(num);
        
    }
    if(o==='+'){
        eq=eq+parseFloat(num);
        
    }
    if(o==='-'){
        eq=eq-parseFloat(num);
        
    }
    document.querySelector("#display").innerText=eq;
}



function clr(){
    num="";
    eq=0;
    document.querySelector("#display").innerText=eq;

}