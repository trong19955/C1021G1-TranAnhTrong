let fibonacciArr = [0, 1];
function addFibonacci(num1, num2) {
    if (num2 <= 200) {
        let nextNum = num1 + num2;
        fibonacciArr[fibonacciArr.length] = nextNum;
        num1 = num2;
        num2 = nextNum;
        return addFibonacci(num1, num2);
    }
    return fibonacciArr;
}
addFibonacci(fibonacciArr[0], fibonacciArr[1]);
let sum = 0;
fibonacciArr.forEach((num) => {
    console.log(num);
    sum += num;
});
console.log(`tổng của fibonacci sẽ là: ${sum}`);
//# sourceMappingURL=main.js.map