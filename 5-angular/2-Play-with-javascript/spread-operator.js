

let arr1 = [1, 2, 3, 4]
let arr2 = [7, 8, 9]

let arr3 = [...arr1, 5, 6, ...arr2]



let o1 = { x: 10, y: 20 }
let o2 = { y: 25, z: 30 }
let o3 = { ...o2, ...o1 }



function display(x, y, z) {
    console.log(x, y, z);
}

// let arr = [10, 20, 30];
// display(...arr)


//------------------------------------------------------------------------


let itetableObj = {
    [Symbol.iterator]: function () {
        let i = 0;
        return {
            next: function () {
                i++;
                let value = i <= 10 ? i : undefined;
                let done = i > 10;
                return { value, done }
            }
        }
    }
}

let numbers = [...itetableObj]
console.log(numbers);


//------------------------------------------------------------------------

