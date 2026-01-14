let name = "Siddhesh";

console.log(name);
let name1 = "sandy"; 

function A(){
    name1 = "Sumed";
    console.log(name);
    name = 'Sairaj';
    console.log(name);
    console.log(name1);
}

A();
console.log(name1);


console.log(name);

console.log(x); // undefined
var x = 10;
console.log(y); // Error (TDZ)
var y = 20;

const obj = {name : "Siddhesh"};
console.log(obj.name);

let arr = new Array(5);
console.log(arr);

let array = Array.of(5,6);
console.log(array);

