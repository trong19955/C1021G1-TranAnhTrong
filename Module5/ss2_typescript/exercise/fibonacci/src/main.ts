function fibonacci(count: number):number{
    if (count <=2){
        return count-1;
    }
    return fibonacci(count -1 )+fibonacci(count -2);
}
let sum = 0;
for (let i = 1; i <= 10; i++) {
    console.log(fibonacci(i))
    sum = fibonacci(i);
    sum += sum;
}
console.log(`tổng của fibonacci sẽ là: ${sum}`)