let fibonacciArr: number[] = [0,1];

function addFibonacci(num1: number, num2: number):number[] {
    if (num2 <= 200) {
        let nextNum = num1 + num2;
        fibonacciArr[fibonacciArr.length] = nextNum;

        num1 = num2;
        num2 = nextNum;

        return addFibonacci(num1,num2);
    }

    return fibonacciArr;

}

addFibonacci(fibonacciArr[0],fibonacciArr[1]);

let sum: number = 0;

fibonacciArr.forEach((num) => {
    console.log(num);
    sum += num;
})

console.log(`tổng của fibonacci sẽ là: ${sum}`);
